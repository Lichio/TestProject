package org.rabbitMQ.confirm;

import org.rabbitMQ.scenario.asynchronous.Util;

/**
 * TestProject org.rabbitMQ.confirm
 *
 * @author Lichaojie
 * @version 2019/4/29 11:32
 */
public class SimpleRecv {
	public static void main(String[] args){
		Util.recvMessage(SimpleConfirm.QUEUE_NAME);
	}
}
