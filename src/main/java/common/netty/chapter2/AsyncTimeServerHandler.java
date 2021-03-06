package common.netty.chapter2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * org.test.test21
 * Created on 2017/11/30
 *
 * @author Lichaojie
 * AIO实现的时间服务器-服务端
 */
public class AsyncTimeServerHandler implements Runnable{
	private int port;

	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;

	public AsyncTimeServerHandler(int port){
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The server is start in port : " + port);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	public void doAccept(){
		asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
	}
}

class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncTimeServerHandler>{
	@Override
	public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment){
		attachment.asynchronousServerSocketChannel.accept(attachment,this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer,buffer,new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc,AsyncTimeServerHandler attachment){
		exc.printStackTrace();
		attachment.latch.countDown();
	}
}

class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer>{
	private AsynchronousSocketChannel channel;

	public ReadCompletionHandler(AsynchronousSocketChannel channel){
		if(this.channel == null){
			this.channel = channel;
		}
	}

	@Override
	public void completed(Integer result,ByteBuffer attachment){
		attachment.flip();
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			String req = new String(body,"UTF-8");
			System.out.println("The time server receive order : " + req);
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
			doWrite(currentTime);
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}

	private void doWrite(String currentTime){
		if(currentTime != null && currentTime.trim().length() > 0){
			byte[] bytes = currentTime.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer buffer) {
					if(buffer.hasRemaining()){
						channel.write(buffer,buffer,this);
					}
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					}catch (IOException e){

					}
				}
			});
		}
	}

	@Override
	public void failed(Throwable exc,ByteBuffer attachment){
		try {
			this.channel.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}