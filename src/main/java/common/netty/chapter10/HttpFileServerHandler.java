package common.netty.chapter10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * TestProject common.netty.chapter10
 *
 * @author Lichaojie
 * @version 2018/3/29 16:38
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	@Override
	public void messageReceived(ChannelHandlerContext ctx,FullHttpRequest request) throws Exception{
		//
	}
}
