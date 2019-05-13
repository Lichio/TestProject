package org.rabbitMQ.scenario.sequence;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 16:30
 */
public class Util {

    /**
     * 存储已经处理过的任务(需要所有消费者共享)
     */
    private static Map<String, List<Integer>> doneTasks = new ConcurrentHashMap<>();

    /**
     * 根据已有信息创建订单消息（此处信息均为测试数据）
     * @return
     */
    public static OrderMessage createOrderMessage(){

        //getOrderInfo();

        long id = 1;
        Date time = new Date(System.currentTimeMillis());

        OrderSequence orderSequence = new OrderSequence();
        orderSequence.setOrderNumber(id + time.toString())
                .setTaskNumber(TaskNumber.createOrder);

        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setId(id)
                .setTime(time)
                .setSequence(orderSequence);

        return orderMessage;
    }


    /**
     * 获取订单信息
     * @return
     */
    private static Object getOrderInfo(){
        return new Object();
    }

    /**
     * 处理收到的任务
     * @param message
     *
     * 此处只考虑两个任务的情况，如果超过两个任务，我们可以根据订单号对不同任务设置锁，同一订单号下的不同任务使用锁控制执行顺序（可能需要非常多的锁…）
     */
    public static void doTask(OrderMessage message){

        String orderNumber = message.getSequence().getOrderNumber();
        int taskNumber = message.getSequence().getTaskNumber().getIndex();

        if (doneTasks.containsKey(orderNumber)){ // 1号任务执行了，收到的2号任务直接执行
            List<Integer> tasks = doneTasks.get(orderNumber);
            int lastTask = tasks.get(tasks.size() - 1);
            if(lastTask + 1 == taskNumber) { // 此处为taskNumber为2的情况
                updateStock();
                doneTasks.get(orderNumber).add(taskNumber);
            }
        } else {
            if (taskNumber == 1) { // 1号任务没有执行，收到1号任务直接执行
                createOrder();
                doneTasks.get(orderNumber).add(taskNumber);
            } else { // 1号任务没有执行，收到2号任务则不能执行
                while (!doneTasks.containsKey(orderNumber)){
                    // 阻塞，直到1号任务被执行
                }
                updateStock();
                doneTasks.get(orderNumber).add(taskNumber);
            }
        }

    }

    /**
     * 完成创建订单的任务
     */
    private static void createOrder(){

    }

    /**
     * 完成更新库存的任务
     */
    private static void updateStock(){

    }
}
