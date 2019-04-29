package org.rabbitMQ.scenario.asynchronous;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:38
 *
 * 接收短信消息进行处理
 */
public class SMSRecv {
	public static void main(String[] args){
		Util.recvMessage("sms");
	}
}
