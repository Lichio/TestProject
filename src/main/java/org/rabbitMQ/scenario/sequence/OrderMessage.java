package org.rabbitMQ.scenario.sequence;

import java.util.Date;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 16:18
 *
 * 订单消息
 */
public class OrderMessage {
    private long id;
    private Date time;
    private OrderSequence sequence;

    public long getId() {
        return id;
    }

    public OrderMessage setId(long id) {
        this.id = id;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public OrderMessage setTime(Date time) {
        this.time = time;
        return this;
    }

    public OrderSequence getSequence() {
        return sequence;
    }

    public OrderMessage setSequence(OrderSequence sequence) {
        this.sequence = sequence;
        return this;
    }
}
