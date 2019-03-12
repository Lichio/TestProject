package org.proxy.jdkProxy;

/**
 * Created by Lichaojie on 2017/8/24. It's a beautiful day.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        Service serviceProxy = (Service)handler.getProxy();
        serviceProxy.add();
    }

}
