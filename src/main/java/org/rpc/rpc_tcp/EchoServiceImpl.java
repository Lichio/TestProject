package org.rpc.rpc_tcp;

/**
 * TestProject org.test23
 *
 * @author Lichaojie
 * @version 2017/12/22 9:57
 */
public class EchoServiceImpl implements EchoService{
	@Override
	public String echo(String ping){
		return ping != null ? ping + " --> I am ok." : "I am ok.";
	}
}
