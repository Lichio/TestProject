package org.httpparse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * TestProject org.test24
 *
 * @author Lichaojie
 * @version 2018/1/16 17:24
 *
 * 接收HTTP请求报文，解析并打印
 */
public class HttpServer {
	public static void main(String[] args) throws Exception{
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8080));

		ssc.configureBlocking(false);

		Selector selector = Selector.open();
		ssc.register(selector,SelectionKey.OP_ACCEPT);

		while (true){
			if (selector.select(3000) == 0){
				continue;
			}

			Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

			while (keyIterator.hasNext()){
				SelectionKey key = keyIterator.next();
				new Thread(new HttpHandler(key)).run();
				keyIterator.remove();
			}
		}
	}

	public static class HttpHandler implements Runnable{
		private int bufferSize = 1024;
		private String localCharset = "UTF-8";
		private SelectionKey key;

		public HttpHandler(SelectionKey key){
			this.key = key;
		}

		public void handlerAccept() throws IOException{
			SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
			clientChannel.configureBlocking(false);
			clientChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
		}

		public void handlerRead() throws IOException{
			SocketChannel sc = (SocketChannel)key.channel();
			ByteBuffer buffer = (ByteBuffer)key.attachment();
			buffer.clear();
			if (sc.read(buffer) == -1){
				sc.close();
			} else {
				buffer.flip();
				String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
				String[] requestMessage = receivedString.split("\r\n");
				for (String s : requestMessage){
					System.out.println(s);
					if(s.isEmpty())
						break;
				}

				String[] firstLine = requestMessage[0].split(" ");
				System.out.println();
				System.out.println("Method:\t" + firstLine[0]);
				System.out.println("url:\t" + firstLine[1]);
				System.out.println("HTTP Version:\t" + firstLine[2]);
				System.out.println();

				StringBuilder sendString = new StringBuilder();
				sendString.append("HTTP/1.1 200 OK\r\n");
				sendString.append("Content-Type:text/html;charset=" + localCharset + "\r\n");
				sendString.append("\r\n");

				sendString.append("<html><head><title>显示报文</title></head><body>");
				sendString.append("接收到的请求报文是:<br/>");
				for (String s : requestMessage){
					sendString.append(s + "<br/>");
				}
				sendString.append("</body></html>");
				buffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
				sc.write(buffer);
				sc.close();
			}
		}

		@Override
		public void run(){
			try {
				if(key.isAcceptable()){
					handlerAccept();
				}
				if (key.isReadable()){
					handlerRead();
				}
			}catch (IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
