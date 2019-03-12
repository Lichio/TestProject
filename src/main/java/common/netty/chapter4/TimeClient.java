package common.netty.chapter4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * TestProject common.netty.chapter4
 *
 * @author Lichaojie
 * @version 2018/3/28 16:05
 */
public class TimeClient {

	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)                                           //设置IO线程组
					.channel(NioSocketChannel.class)                 //指定客户端使用的channel
					.option(ChannelOption.TCP_NODELAY,true)   //设置客户端TCP参数
					.handler(                                        //设置Handler
							/**
							 * ChannelInitializer继承ChannelHandlerAdapter，当TCP链路注册成功之后，
							 * 调用initChannel接口，用于设置用户ChannelHandler
							 * ChannelInitializer在channelRegistered方法中主动调用inITChannel方法
							 */
							new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception{
							ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new TimeClientHandler());
						}
					});

			ChannelFuture f = b.connect(host,port);

			f.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully();
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
		new TimeClient().connect(port,"127.0.0.1");
	}
}
