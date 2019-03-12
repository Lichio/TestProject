package org.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LiChaojie on 2016/3/14.
 */
public class ThreadPoolTest {
    public static  void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(6);
        Runnable target = () -> {
            for(int i = 0 ; i < 20 ; i ++){
                System.out.println(Thread.currentThread().getName() + " i:" + i);
            }
        };

        es.submit(target);
        es.submit(target);
        es.shutdown();
    }
}
