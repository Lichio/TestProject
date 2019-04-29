package org.rabbitMQ.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TestProject org.rabbitMQ.tx
 *
 * @author Lichaojie
 * @version 2019/4/29 9:48
 *
 * ����
 */
public class TxSend {
	public static void main(String[] args) throws Exception{
		final String QUEUE_NAME = "tx-test";

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		try{
			channel.txSelect(); // ��������
			String message = "tx-message";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			channel.txCommit(); // �ύ����
		}catch (Exception ex){
			channel.txRollback(); // �ع�����
		}finally {
			connection.close();
			channel.close();
		}
	}
}
