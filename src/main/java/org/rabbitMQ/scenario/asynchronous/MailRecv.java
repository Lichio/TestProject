package org.rabbitMQ.scenario.asynchronous;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:26
 *
 * 接收邮件消息进行处理
 */
public class MailRecv {
	public static void main(String[] args) throws Exception{
		Util.recvMessage("mail");
	}
}
