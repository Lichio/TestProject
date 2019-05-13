package org.rabbitMQ.scenario.sequence;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 16:15
 */
public class MsgSend {
    private final static String QUEUE_NAME = "order";

    public static void main(String[] argv) throws Exception {
        OrderMessage orderMessage = Util.createOrderMessage();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            channel.basicPublish("", QUEUE_NAME, null, JSON.toJSONBytes(orderMessage));
        }
    }
}
