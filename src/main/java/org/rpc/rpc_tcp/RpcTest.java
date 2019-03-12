package org.rpc.rpc_tcp;

import java.net.InetSocketAddress;

/**
 * TestProject org.test23
 *
 * @author Lichaojie
 * @version 2017/12/22 10:40
 */
public class RpcTest {
	public static void main(String[] args) throws Exception{
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					RpcExporter.exporter("localhost",8088);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}).start();

		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
		System.out.println(echo.echo("Are you ok ?"));
	}
}
