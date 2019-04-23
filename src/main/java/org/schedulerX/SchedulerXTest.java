package org.schedulerX;

import com.alibaba.edas.schedulerx.SchedulerXClient;

/**
 * TestProject org.schedulerX
 *
 * @author Lichaojie
 * @version 2019/4/11 11:36
 */
public class SchedulerXTest {
	public static void main(String[] args){
		SchedulerXClient schedulerXClient = new SchedulerXClient();
		// ������������ ID
		schedulerXClient.setGroupId("101-1-2-5357");
		// Ӧ�ò���ĵ����Ӧ�� regionName
		schedulerXClient.setRegionName("cn-hangzhou");
		// Ӧ�ò���ĵ����Ӧ�� SchedulerX �� domainName
		schedulerXClient.setDomainName("schedulerx-finance-hz.console.aliyun.com");
		try {
			schedulerXClient.init();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
