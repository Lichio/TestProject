package org.rabbitMQ.scenario.asynchronous;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:26
 *
 * �����ʼ���Ϣ���д���
 */
public class MailRecv {
	public static void main(String[] args) throws Exception{
		Util.recvMessage("mail");
	}
}
