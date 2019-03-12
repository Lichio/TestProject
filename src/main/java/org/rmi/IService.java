package org.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * org.test20
 * Created on 2017/11/17
 *
 * @author Lichaojie
 */
public interface IService extends Remote{
	String service(String content) throws RemoteException;
}
