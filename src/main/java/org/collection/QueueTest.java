package org.collection;

import java.util.PriorityQueue;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class QueueTest {
    //Queueģ������������ݽṹ��
    //PriorityQueue������Ԫ�ؽ��������������Ա���Ԫ�ص�˳�򲢲���Ԫ�ؼ������ʱ��˳��

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(9);
        priorityQueue.add(-8);
        priorityQueue.add(4);
        priorityQueue.add(-3);


        System.out.println(priorityQueue);
    }
}
