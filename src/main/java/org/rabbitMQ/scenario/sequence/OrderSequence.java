package org.rabbitMQ.scenario.sequence;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 15:51
 *
 * 订单序列号
 */
public class OrderSequence {
    /**
     * 每个订单有一个唯一的订单号，可根据用户ID、下单时间等创建一个和用户相关的全局唯一的订单号
     */
    private String orderNumber;

    /**
     * 每个订单下有多个不同任务，这些任务需要按此编号顺序执行
     */
    private TaskNumber taskNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public OrderSequence setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public TaskNumber getTaskNumber() {
        return taskNumber;
    }

    public OrderSequence setTaskNumber(TaskNumber taskNumber) {
        this.taskNumber = taskNumber;
        return this;
    }
}
