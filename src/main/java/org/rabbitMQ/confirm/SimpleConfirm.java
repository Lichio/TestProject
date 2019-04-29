package org.rabbitMQ.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TestProject org.rabbitMQ.confirm
 *
 * @author Lichaojie
 * @version 2019/4/29 9:57
 *
 * 普通Confirm确认
 */
public class SimpleConfirm {
	static final String QUEUE_NAME = "simple-confirm";

	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			// 开启发送方确认
			channel.confirmSelect();
			String message = "confirm message";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			// 等待服务器返回确认消息
			if (channel.waitForConfirms()){
				System.out.println(" [x] Sent '" + message + "'");
			}
		}
	}


}
