package org.thread;

/**
 * Created by LiChaojie on 2016/3/11.
 */
//实现Runnable接口创建线程类
public class SecondThread implements Runnable{
    private int i;


    public void run(){
        for ( ; i < 100 ; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args){
        for(int i = 0 ; i < 100 ; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                Runnable st = new SecondThread();
                new Thread(st).start();
                new Thread(st).start();
            }
        }
    }
}
