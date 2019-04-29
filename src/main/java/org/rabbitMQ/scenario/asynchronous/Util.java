package org.rabbitMQ.scenario.asynchronous;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:23
 */
public class Util {

	/**
	 * 从MQ接收消息 并处理
	 * @param queueName 队列名
	 */
	public static void recvMessage(String queueName){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try{
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(queueName, false, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				if (queueName.equals("mail")){
					sendMail();
				}else if (queueName.equals("sms")){
					sendSMS();
				}else {

				}
				String message = new String(delivery.getBody(), "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			};
			channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
		}catch (Exception ex){

		}
	}

	/**
	 * 将消息发送到对应的MQ中
	 * @param queueName 队列名
	 * @param message 消息内容
	 */
	public static void postMessage(String queueName, String message){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(queueName, false, false, false, null);
			channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
//			System.out.println(" [x] Send '" + message + "'");
		}catch (Exception ex){

		}
	}

	/**
	 * 插入数据
	 */
	public static void insertData(){
		try {
			Thread.sleep(50);
			System.out.println("insert data done.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 */
	public static void sendMail(){
		try {
			Thread.sleep(50);
			System.out.println("send mail done.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送短信
	 */
	public static void sendSMS(){
		try {
			Thread.sleep(50);
			System.out.println("send message done.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
