package org.thread;

/**
 * Created by LiChaojie on 2016/3/14.
 */
public class SynChronizedTest {
    //同步代码块
    //obj是同步监视器，线程开始执行之前，必须先获得对同步监视器的锁定
    //synchronized (obj){
    //    ...
        //此处的代码就是同步代码块
    //}

    //同步方法，用synchronized修饰的方法称作同步方法
    //对于synchronized修饰的方法，无须指定同步监视器，同步方法的同步监视器是this。
}
