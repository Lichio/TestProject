package org.thread;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class PriorityTest extends Thread {
    public PriorityTest(String name){
        super(name);
    }

    public void run(){
        for(int i = 0 ; i < 50; i ++){
            System.out.println(getName() + "£¬priority:" + getPriority() + ",i:" + i);
        }
    }

    public static void main(String[] args){
        Thread.currentThread().setPriority(6);
        for(int i = 0 ; i < 30 ; i ++){
            if(i == 10){
                PriorityTest pt1 = new PriorityTest("low_priority");
                pt1.start();
                System.out.println("the initial priority:" + pt1.getPriority());
                pt1.setPriority(MIN_PRIORITY);
            }
            if(i == 20){
                PriorityTest pt2 = new PriorityTest("high_priority");
                pt2.start();
                System.out.println("the initial priority:" + pt2.getPriority());
                pt2.setPriority(MAX_PRIORITY);
            }
        }
    }
}
