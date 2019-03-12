package common.thread.produce$consume;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * TestProject common.thread.produce$consume
 *
 * @author Lichaojie
 * @version 2018/5/14 15:00
 *
 * 使用阻塞【队列方式】实现生产者消费者
 */
public class Storage3 implements Storage{
	// 仓库最大存储量
	private final int MAX_SIZE = 100;

	// 仓库存储的载体
	private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(MAX_SIZE);


	// 生产num个产品
	@Override
	public void produce(int num) {

		try {
			for (int i = 0 ; i < num; i ++){
				//队列满，put()方法阻塞
				queue.put(new Object());
			}
			System.out.println("【已经生产产品数】:" + num);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	// 消费num个产品
	@Override
	public void consume(int num) {
		try {
			for (int i = 0 ; i < num; i ++){
				//队列空，take()方法阻塞
				queue.take();
			}
			System.out.println("【已经消费产品数】:" + num);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	public LinkedBlockingQueue<Object> getQueue() {
		return queue;
	}

	public Storage3 setQueue(LinkedBlockingQueue<Object> queue) {
		this.queue = queue;
		return this;
	}
}
