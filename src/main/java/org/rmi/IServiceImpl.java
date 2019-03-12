package org.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * org.test20
 * Created on 2017/11/17
 *
 * @author Lichaojie
 */
public class IServiceImpl extends UnicastRemoteObject implements IService{

	private String name;

	public IServiceImpl(String name) throws RemoteException{
		this.name = name;
	}

	@Override
	public String service(String content){
		return "Hello " + content;
	}
}
