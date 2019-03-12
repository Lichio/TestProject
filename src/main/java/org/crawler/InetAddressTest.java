package org.crawler;

import java.net.*;
/**
 * Created by LiChaojie on 2016/9/5.
 */
public class InetAddressTest {
    public static void main(String[] args){
        try{
            InetAddress address1 = InetAddress.getByName("www.baidu.com");
            System.out.println(address1);

//            InetAddress address2 = InetAddress.getByName("180.97.33.107");
//            System.out.println(address2.getHostName());

            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            for(InetAddress address : addresses){
                System.out.println(address);
            }

            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println(localAddress);
        }catch(UnknownHostException ex){
            System.out.println("could not find the host!");
        }
    }
}
