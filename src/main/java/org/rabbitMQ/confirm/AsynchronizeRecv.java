package org.rabbitMQ.confirm;

import org.rabbitMQ.scenario.asynchronous.Util;

/**
 * TestProject org.rabbitMQ.confirm
 *
 * @author Lichaojie
 * @version 2019/4/29 11:35
 */
public class AsynchronizeRecv {
	public static void main(String[] args){
		Util.recvMessage(AsynchronizeConfirm.QUEUE_NAME);
	}
}
