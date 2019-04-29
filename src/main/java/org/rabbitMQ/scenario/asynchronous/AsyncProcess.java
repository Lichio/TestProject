package org.rabbitMQ.scenario.asynchronous;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 16:08
 */
public class AsyncProcess {
	public static void main(String[] args) throws Exception{

		long start = System.currentTimeMillis();
		strategy1();
		long end = System.currentTimeMillis();
		System.out.println("Synchronized Time : " + (end - start));

		start = System.currentTimeMillis();
		strategy2();
		end = System.currentTimeMillis();
		System.out.println("Asynchronized Time : " + (end - start));
	}

	/**
	 * ����ͬ������
	 */
	public static void strategy1() throws Exception{
		Util.insertData();

		Thread.sleep(600);// ����ͨ��ʱ�俪��
		Util.sendMail();

		Thread.sleep(600);
		Util.sendSMS();
	}

	/**
	 * ʹ����Ϣ�����첽����
	 */
	public static void strategy2(){
		Util.insertData();

//		long start = System.currentTimeMillis();
		Util.postMessage("mail","mail content");
//		long end = System.currentTimeMillis();
//		System.out.println("Network cost 1 : " + (end - start));

//		start = System.currentTimeMillis();
		Util.postMessage("sms","sms content");
//		end = System.currentTimeMillis();
//		System.out.println("Network cost 2 : " + (end - start));
	}




}
