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
			b.group(group)                                           //����IO�߳���
					.channel(NioSocketChannel.class)                 //ָ���ͻ���ʹ�õ�channel
					.option(ChannelOption.TCP_NODELAY,true)   //���ÿͻ���TCP����
					.handler(                                        //����Handler
							/**
							 * ChannelInitializer�̳�ChannelHandlerAdapter����TCP��·ע��ɹ�֮��
							 * ����initChannel�ӿڣ����������û�ChannelHandler
							 * ChannelInitializer��channelRegistered��������������inITChannel����
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
