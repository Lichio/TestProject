package common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * TestProject org.test.test25
 *
 * @author Lichaojie
 * @version 2018/3/3 16:28
 */

	public class SemaphoreDemo implements Runnable {
	     final Semaphore semaphore = new Semaphore(5);
	     @Override
	     public void run() {
		        try {
			             semaphore.acquire();
			             Thread.sleep(1000);
			             System.out.println(Thread.currentThread().getId()+" :done!");
			             semaphore.release();
			        } catch (InterruptedException e) {
			             e.printStackTrace();
			         }
		     }

		     public static void main(String[] args) {
		         ExecutorService exec = Executors.newFixedThreadPool(20);
		         final SemaphoreDemo demo = new SemaphoreDemo();
		         for(int i =0;i<20;i++){
			             exec.submit(demo);
		         }
		         exec.shutdown();
		     }
}


