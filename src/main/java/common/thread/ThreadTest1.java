package common.thread;

/**
 * TestProject org.test27
 *
 * @author Lichaojie
 * @version 2018/3/24 18:00
 *
 * 三个线程依次打印ABCABCABC……
 */
public class ThreadTest1 implements Runnable{

	public static volatile int i = 0;

	@Override
	public void run(){
		while (true){
			synchronized (this){
				if(i == 0){
					System.out.print("A");
				}else if(i == 1){
					System.out.print("B");
				}else {
					System.out.print("C");
				}
				i = (i + 1) % 3;
			}
		}
	}


	public static void main(String[] args){
		Thread threadA = new Thread(new ThreadTest1());
		Thread threadB = new Thread(new ThreadTest1());
		Thread threadC = new Thread(new ThreadTest1());

		threadA.start();
		threadB.start();
		threadC.start();
	}

}
