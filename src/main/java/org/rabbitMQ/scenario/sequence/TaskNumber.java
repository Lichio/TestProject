package org.rabbitMQ.scenario.sequence;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 15:52
 *
 * 任务编号（同一个订单下的多个任务）
 */
public enum TaskNumber {
    createOrder(1,"创建订单"),
    updateStock(2,"更新库存");

    private int index;
    private String description;

    TaskNumber(int index, String description){
        this.index = index;
        this.description = description;
    }

    public int getIndex(){
        return this.index;
    }

    public String getDescription(){
        return this.description;
    }

}
