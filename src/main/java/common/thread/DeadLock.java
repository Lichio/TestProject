package common.thread;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TestProject org.test.test25
 *
 * @author Lichaojie
 * @version 2018/3/12 11:25
 */
public class DeadLock {

	public static void main(String[] args){
		Runnable runnable1 = () -> {
			synchronized (Integer.class){
				System.out.println(Thread.currentThread().getName() + " Integer");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (String.class){
					System.out.println(Thread.currentThread().getName() + " String");
				}
			}
		};

		Runnable runnable2 = () -> {
			synchronized (String.class){
				System.out.println(Thread.currentThread().getName() + " String");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (Integer.class){
					System.out.println(Thread.currentThread().getName() + " Integer");
				}
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(runnable1);
		executorService.submit(runnable2);
//		new Thread(runnable1,"thread1").start();
//		new Thread(runnable2,"thread2").start();

	}
}
