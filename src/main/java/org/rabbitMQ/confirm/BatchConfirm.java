package org.rabbitMQ.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TestProject org.rabbitMQ.confirm
 *
 * @author Lichaojie
 * @version 2019/4/29 10:10
 *
 * 批量Confirm模式
 */
public class BatchConfirm {
	static final String QUEUE_NAME = "batch-confirm";

	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			// 开启发送方确认
			channel.confirmSelect();
			for (int i = 0; i < 10; i ++){
				channel.basicPublish("", QUEUE_NAME, null, ("confirm message " + i).getBytes("UTF-8"));
			}
			// 直到所有信息都发布，只要有一个未确认就会IOException
			channel.waitForConfirmsOrDie();
			System.out.println("消息全部发送成功！");
		}
	}
}
