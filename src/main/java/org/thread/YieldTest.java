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
                //yield()ֻ���õ�ǰ�߳���ͣһ�£���ϵͳ���̵߳��������µ���һ�Σ�
                //��ȫ���ܵ�����ǣ���ĳ���̵߳�����yield()���̵߳������ֽ�����ȳ�������ִ�С�
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
