package org.lock;

/**
 * Created by LiChaojie on 2016/5/5.
 */
public class UnsynchBank {
    //未同步的银行程序，多次转账之后，所有用户的总金额发生变化
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args){
        Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for(int i = 0 ; i < NACCOUNTS; i ++){
            //多个线程同时对账户进行转账操作
            TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Bank{
    protected final double[] accounts;

    public Bank(int n,double initialBalance){
        accounts = new double[n];
        for(int i = 0 ; i < accounts.length ; i ++){
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount) return;
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] += amount;
        System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
    }

    public double getTotalBalance(){
    double sum = 0;
    for(double a : accounts){
        sum += a;
    }
    return sum;
}

    public int size(){
        return accounts.length;
    }
}

class TransferRunnable implements Runnable{
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank b,int from,double max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run(){
        try{
            while(true){
                int toAccount = (int)(bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount,toAccount,amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (InterruptedException e){}
    }
}