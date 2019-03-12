package common.thread.produce$consume;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * TestProject common.thread.produce$consume
 *
 * @author Lichaojie
 * @version 2018/5/14 15:00
 *
 * ʹ�����������з�ʽ��ʵ��������������
 */
public class Storage3 implements Storage{
	// �ֿ����洢��
	private final int MAX_SIZE = 100;

	// �ֿ�洢������
	private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(MAX_SIZE);


	// ����num����Ʒ
	@Override
	public void produce(int num) {

		try {
			for (int i = 0 ; i < num; i ++){
				//��������put()��������
				queue.put(new Object());
			}
			System.out.println("���Ѿ�������Ʒ����:" + num);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	// ����num����Ʒ
	@Override
	public void consume(int num) {
		try {
			for (int i = 0 ; i < num; i ++){
				//���пգ�take()��������
				queue.take();
			}
			System.out.println("���Ѿ����Ѳ�Ʒ����:" + num);
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
