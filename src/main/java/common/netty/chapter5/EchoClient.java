package common.netty.chapter5;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ClientDecoder;
import io.netty.handler.codec.string.StringDecoder;


/**
 * TestProject common.netty.chapter5
 *
 * @author Lichaojie
 * @version 2018/3/28 18:07
 */
public class EchoClient {
	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY,true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch){
							ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
							ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
							//ch.pipeline().addLast(new FixedLengthFrameDecoder(20));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new EchoClientHandler());
						}
					});

			ChannelFuture f = b.connect(host,port).sync();

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

		new EchoClient().connect(port,"127.0.0.1");
	}
}
