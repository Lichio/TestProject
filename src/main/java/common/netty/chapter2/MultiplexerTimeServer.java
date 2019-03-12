package common.netty.chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * org.test.test21
 * Created on 2017/11/29
 *
 * @author Lichaojie
 * NIO实现的时间服务器-服务端
 */

/**
 * 使用NIO进行服务端开发的步骤
 *  1. 创建ServerSocketChannel，配置它为非阻塞模式
 *  2. 绑定监听，配置TCP、参数，例如backlog大小
 *  3. 创建一个独立的I/O线程，用于轮训多路复用器Selector
 *  4. 创建Selector，将之前创建的ServerSocketChannel注册到Selector上，监听SelectionKey.ACCEPT
 *  5. 启动I/O线程，在循环体中执行Selector.select()方法，轮训就绪的Channel
 *  6. 当轮训到了处于就绪状态的Channel时，需要对其进行判断，如果是OP_ACCEPT状态，说明是新的客户端接入，则调用ServerSocketChannel.accept()方法接受新的客户端
 *  7. 设置新接入的客户端链路SocketChannel为非阻塞模式，配置其它一些TCP参数
 *  8. 将SocketChannel注册到Selector，监听OP_READ操作位
 *  9. 如果轮训的Channel为OP_READ，则说明SocketChannel中有新的就绪的数据包需要读取，则构造ByteBuffer对象，读取数据包
 * 10. 如果轮训的Channel为OP_WRITE，说明还有数据没有发送完成，需要继续发送
 */
public class MultiplexerTimeServer implements Runnable {
	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	private volatile boolean stop;

	public MultiplexerTimeServer(int port){
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port : " + port);
		}catch (IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop(){
		this.stop = true;
	}

	@Override
	public void run(){
		while (!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()){
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					}catch (Exception e){
						if(key != null){
							key.cancel();
							if (key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			}catch (Throwable t){
				t.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector,SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					System.out.println("The time server receive order : " + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					doWrite(sc,currentTime);
				}else if(readBytes < 0){
					key.cancel();
					sc.close();
				}else {

				}
			}
		}
	}

	private void doWrite(SocketChannel channel,String response) throws IOException{
		if(response != null && response.trim().length() > 0){
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}
}
