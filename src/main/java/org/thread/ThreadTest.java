package org.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiChaojie on 2016/5/24.
 */
public class ThreadTest {
    // 1.通过构造实现Runnable接口的类，通过这个类构造Thread类
    //      RunnableTest implements Runnable(RunnableTest 须实现Runnable接口中的run()方法)
    //      Thread thread = new Thread(RunnableTest);
    //      thread.start();

    // 2.通过继承Thread类，并重写run()方法
    //      ThreadTest extends Thread
    //      Thread thread = new ThreadTest("线程名");
    //      thread.start();
    private static int x = 1;
    private static int y = 2;
    private static Lock lock = new ReentrantLock();
    private static Lock locktest = new ReentrantLock();

    private static class RunnableTest implements Runnable{
        @Override
        public void run(){
            try{
                y = 3;
                Thread.currentThread().sleep(1000);
                lock.lock();
                x = 2;
                lock.unlock();
            }catch (InterruptedException ie){

            }
        }
    }

    private static class Thread2 extends Thread{
        @Override
        public void run(){
            System.out.println("y:" + y);
            lock.lock();
            System.out.println("x:" + x);
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(new RunnableTest());
        thread1.start();
        //thread1.sleep(1000);
        Thread thread2 = new Thread2();
        thread2.start();

        System.out.println((lock == locktest) ? "true!" : "false!");
    }
}
