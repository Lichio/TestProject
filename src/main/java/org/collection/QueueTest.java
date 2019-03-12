package org.collection;

import java.util.PriorityQueue;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class QueueTest {
    //Queue模拟队列这种数据结构。
    //PriorityQueue将队列元素进行重新排序，所以保存元素的顺序并不是元素加入队列时的顺序。

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(9);
        priorityQueue.add(-8);
        priorityQueue.add(4);
        priorityQueue.add(-3);


        System.out.println(priorityQueue);
    }
}
