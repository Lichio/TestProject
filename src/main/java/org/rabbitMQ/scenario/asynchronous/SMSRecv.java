package org.rabbitMQ.scenario.asynchronous;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:38
 *
 * ���ն�����Ϣ���д���
 */
public class SMSRecv {
	public static void main(String[] args){
		Util.recvMessage("sms");
	}
}
