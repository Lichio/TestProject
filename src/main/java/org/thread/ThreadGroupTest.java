package org.thread;

/**
 * Created by LiChaojie on 2016/5/5.
 */
public class ThreadGroupTest extends ThreadGroup{
    public ThreadGroupTest(String name){super(name);}

    public static void main(String[] args){
        ThreadGroup threadGroup = new ThreadGroupTest("group");

        //����thread-0��thread-1���������߳���threadGroup��
        Thread thread0 = new Thread(threadGroup,"thread-0");
        Thread thread1 = new Thread(threadGroup,"thread-1");
        thread0.start();
        thread1.start();
    }
}
