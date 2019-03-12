package org.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiChaojie on 2016/5/5.
 */
public class LockTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args){
        LockBank b = new LockBank(NACCOUNTS,INITIAL_BALANCE);
        for(int i = 0 ; i < NACCOUNTS; i ++){
            //����߳�ͬʱ���˻�����ת�˲���
            TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class LockBank extends Bank{
    //����һ��������
    protected Lock bankLock = new ReentrantLock();

    public LockBank(int n,double initialBalance){
        super(n,initialBalance);
    }

    @Override
    public void transfer(int from, int to, double amount){
        //Ϊת�˲�������
        bankLock.lock();
        try{
            if(accounts[from] < amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
        }finally {
            bankLock.unlock();
        }

    }

}