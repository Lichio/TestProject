package org.rabbitMQ.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * TestProject org.rabbitMQ.confirm
 *
 * @author Lichaojie
 * @version 2019/4/29 10:22
 */
public class AsynchronizeConfirm {
	static final String QUEUE_NAME = "asynchronize-confirm";

	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			// 开启发送方确认
			channel.confirmSelect();
			for (int i = 0; i < 10; i++) {
				channel.basicPublish("", QUEUE_NAME, null, ("confirm message " + i).getBytes("UTF-8"));
			}
			// 异步监听确认和未确认的消息
			channel.addConfirmListener(new ConfirmListener() {
				@Override
				public void handleAck(long l, boolean b) throws IOException {
					System.out.println(String.format("已确认消息，标识：%d，多个消息：%b", l, b));
				}

				@Override
				public void handleNack(long l, boolean b) throws IOException {
					System.out.println("未确认消息，标识：" + l);
				}
			});
		}
	}
}
