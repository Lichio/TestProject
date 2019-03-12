package org.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * org.test20
 * Created on 2017/11/17
 *
 * @author Lichaojie
 */
public class Server{

	public static void main(String[] args){
		try {
			IService iService = new IServiceImpl("iService");
			Context context = new InitialContext();
			LocateRegistry.createRegistry(8888);
			Naming.rebind("rmi://localhost:8888/iService",iService);
		}catch (Exception ex){
			ex.printStackTrace();
			System.out.println("ERROR");
			return;
		}

		System.out.println("服务器向命名表注册了1个远程服务对象！");
	}
}
