package common.netty.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TestProject common.netty.chapter5
 *
 * @author Lichaojie
 * @version 2018/3/28 18:03
 */
public class EchoServerHandler extends ChannelHandlerAdapter {
	int counter = 0;

	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
		//测试DelimiterBasedFrameDecoder解码器是使用的代码
//		String body = (String)msg;
//		System.out.println("This is " + ++ counter + " times receive client : [" + body + "]");
//		body += "$_";
//		ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//		ctx.writeAndFlush(echo);

		System.out.println("Receive client : [" + msg + "]");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
