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
 * 事务
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
			channel.txSelect(); // 开启事务
			String message = "tx-message";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			channel.txCommit(); // 提交事务
		}catch (Exception ex){
			channel.txRollback(); // 回滚事务
		}finally {
			connection.close();
			channel.close();
		}
	}
}
