package org.rabbitMQ.scenario.sequence;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 16:44
 */
public class MsgRecv {
    private final static String QUEUE_NAME = "order";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            OrderMessage orderMessage = (OrderMessage) JSON.parse(delivery.getBody());
            Util.doTask(orderMessage);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
