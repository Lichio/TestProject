package org.rmi;

import java.rmi.Naming;

/**
 * org.test20
 * Created on 2017/11/17
 *
 * @author Lichaojie
 */
public class Client {
	public static void main(String[] args) {
		String url = "rmi://localhost:8888/";
		try {
			// 检索指定的对象。 即找到服务器端相对应的服务对象存根
			IService service = (IService) Naming.lookup(url + "iService");
			Class stubClass = service.getClass();
			System.out.println(service + " 是 " + stubClass.getName() + " 的实例！");
			// 获得本底存根已实现的接口类型
			Class[] interfaces = stubClass.getInterfaces();
			for (Class c : interfaces) {
				System.out.println("存根类实现了 " + c.getName() + " 接口！");
			}
			System.out.println(service.service("kristy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
