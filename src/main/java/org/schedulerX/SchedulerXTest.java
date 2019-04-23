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
		// 调度任务分组的 ID
		schedulerXClient.setGroupId("101-1-2-5357");
		// 应用部署的地域对应的 regionName
		schedulerXClient.setRegionName("cn-hangzhou");
		// 应用部署的地域对应的 SchedulerX 的 domainName
		schedulerXClient.setDomainName("schedulerx-finance-hz.console.aliyun.com");
		try {
			schedulerXClient.init();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
