package org.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TestProject org.test19.cglib
 *
 * @author Lichaojie
 * @version 2019/3/7 18:02
 */
public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("before:" + method.getName());
		Object object = methodProxy.invokeSuper(o, objects);
		System.out.println("after:" + method.getName());
		return object;
	}
}
