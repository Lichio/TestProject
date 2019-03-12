package common.netty.chapter8;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.ObjectOutputStream;

/**
 * TestProject common.netty.chapter8
 *
 * @author Lichaojie
 * @version 2018/3/29 14:56
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq)msg;

		if("Lichaojie".equalsIgnoreCase(req.getUserName())){
			System.out.println("Service accept client subscribe req : [" + req.toString() + "]\n");
			ctx.writeAndFlush(resp(req.getSubReqId()));
		}
	}

	private SubscribeRespProto.SubscribeResp resp(int subReqId){
		SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
		builder.setSubReqId(subReqId);
		builder.setRespCode(0);
		builder.setDesc("Netty Book order succeed, 3 days later, sent to the designated address");
		return builder.build();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
