package org.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiChaojie on 2016/3/14.
 */
public class LockTest {
    //Lock
    //显式定义同步锁对象来实现同步，同步锁对象是Lock对象。

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
