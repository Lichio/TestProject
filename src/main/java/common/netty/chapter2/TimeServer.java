package common.netty.chapter2;

import java.io.IOException;

/**
 * org.test.test21
 * Created on 2017/11/29
 *
 * @author Lichaojie
 */
public class TimeServer {
	public static void main(String[] args) throws IOException{
		int port = 8080;
		if(args != null && args.length > 0){
			try {
				port = Integer.valueOf(args[0]);
			}catch (NumberFormatException e){

			}
		}

//		new Thread(new MultiplexerTimeServer(port),"NIO-MultiplexerTimeServer-001").start();
		new Thread(new AsyncTimeServerHandler(port),"AIO-AsyncTimeServerHandler-001").start();

	}
}
