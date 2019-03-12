package org.thread;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class JoinThread extends Thread{
    JoinThread(String name){
        super(name);
    }

    public void run(){
        for(int i = 0; i < 100; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws Exception{
        new JoinThread("new Thread").start();
        for(int i = 0 ; i < 100; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if( i == 20){
                JoinThread jt =  new JoinThread("Join Thread");
                jt.start();
                //��main�߳��е���join()����main�߳�����ֱ��jtִ����ɣ�
                //��ʱnew Thread��Join Thread����ִ�С�
                jt.join();
            }
        }
    }
}
