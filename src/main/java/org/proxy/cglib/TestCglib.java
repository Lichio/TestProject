package org.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * TestProject org.test19.cglib
 *
 * @author Lichaojie
 * @version 2019/3/7 18:06
 */
public class TestCglib {
	public static void main(String[] args){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ServiceObject.class);
		enhancer.setCallback(new MyMethodInterceptor());

		ServiceObject service = (ServiceObject)enhancer.create();
		service.service();
	}
}
