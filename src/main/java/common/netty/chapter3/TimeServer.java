package common.netty.chapter3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.Socket;

/**
 * TestProject common.netty.chapter3
 *
 * @author Lichaojie
 * @version 2018/3/26 16:33
 */
public class TimeServer {
	public void bind(int port) throws Exception{
		//�����������ӣ�����channel��Ȼ�󴫸�workerGroup
		//Acceptor�̳߳�
		EventLoopGroup bossGroup = new NioEventLoopGroup();

		//Ϊchannel������õ�EventLoop
		//IO�̳߳�
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG,1024)
					.childHandler(new ChildChannelHandler());

			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();

		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
		@Override
		protected void initChannel(SocketChannel arg0) throws Exception{
			arg0.pipeline().addLast(new TimeServerHandler());
		}
	}

	public static void main(String[] args) throws Exception{
		int port = 8080;
		if(args != null && args.length > 0){
			try {
				port = Integer.valueOf(args[0]);
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
		}

		new TimeServer().bind(port);
	}
}
