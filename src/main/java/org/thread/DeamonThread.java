package org.thread;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class DeamonThread extends Thread {
    public void run(){
        for(int i = 0 ; i < 1000 ; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static  void main(String[] args) throws Exception{
        DeamonThread dt = new DeamonThread();
        //将dt设置为后台进程（后台进程在所有前台进程都死亡后会自动死亡）
        dt.setDaemon(true);
        dt.start();
        //Thread.currentThread().sleep(1);
        for(int i = 0 ; i < 10 ; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
