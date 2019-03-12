package common.netty.chapter8;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject common.netty.chapter8
 *
 * @author Lichaojie
 * @version 2018/3/29 12:11
 */
public class TestSubscribeReqProto {

	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
		return req.toByteArray();
	}

	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}

	private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqId(1);
		builder.setUserName("Lichaojie");
		builder.setProductName("Netty Book");
		builder.setAddress("Shang hai");
		return builder.build();
	}

	public static void main(String[] args) throws InvalidProtocolBufferException{
		SubscribeReqProto.SubscribeReq req1 = createSubscribeReq();
		System.out.println("Before encode : \n" + req1.toString());
//		for (byte b : encode(req1)){
//			System.out.print(b + " ");
//		}
//		System.out.println();
		SubscribeReqProto.SubscribeReq req2 = decode(encode(req1));
		System.out.println("After decode : \n" + req1.toString());
		System.out.println("Assert equal : --> " + req2.equals(req1));
	}
}
