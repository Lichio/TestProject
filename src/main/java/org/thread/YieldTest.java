package org.thread;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class YieldTest extends Thread {
    public YieldTest(String name){
        super(name);
    }
    public void run(){
        for(int i = 0; i < 50 ; i ++){
            System.out.println(getName() + " " + i);
            if(i == 20){
                //yield()只是让当前线程暂停一下，让系统的线程调度器重新调度一次，
                //完全可能的情况是：当某个线程调用了yield()后，线程调度器又将其调度出来重新执行。
                Thread.yield();
            }
        }
    }

    public  static void main(String[] args) throws Exception{
        YieldTest yt1 = new YieldTest("high_priority");
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt1.start();

        YieldTest yt2 = new YieldTest("low_priority");
        yt2.setPriority(Thread.MIN_PRIORITY);
        yt2.start();
    }
}
