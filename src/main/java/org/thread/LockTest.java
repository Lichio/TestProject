package org.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiChaojie on 2016/3/14.
 */
public class LockTest {
    //Lock
    //��ʽ����ͬ����������ʵ��ͬ����ͬ����������Lock����

    private final ReentrantLock lock = new ReentrantLock();
    public void m(){
        lock.lock();
        try{
            doSomething();
        }finally {
            lock.unlock();
        }
    }

    public void doSomething(){}
}
