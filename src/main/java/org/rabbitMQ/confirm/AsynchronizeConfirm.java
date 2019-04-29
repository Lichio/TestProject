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
			// �������ͷ�ȷ��
			channel.confirmSelect();
			for (int i = 0; i < 10; i++) {
				channel.basicPublish("", QUEUE_NAME, null, ("confirm message " + i).getBytes("UTF-8"));
			}
			// �첽����ȷ�Ϻ�δȷ�ϵ���Ϣ
			channel.addConfirmListener(new ConfirmListener() {
				@Override
				public void handleAck(long l, boolean b) throws IOException {
					System.out.println(String.format("��ȷ����Ϣ����ʶ��%d�������Ϣ��%b", l, b));
				}

				@Override
				public void handleNack(long l, boolean b) throws IOException {
					System.out.println("δȷ����Ϣ����ʶ��" + l);
				}
			});
		}
	}
}
