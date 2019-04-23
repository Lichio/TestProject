package org.jedis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject org.jedis
 *
 * @author Lichaojie
 * @version 2019/3/12 17:22
 */
public class RedisJava {
	public static void main(String[] args){
		JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
		testString(pool);
//		testPipiline(pool);
		testTransaction(pool);
		pool.close();

	}

	public static void testString(JedisPool pool){
		try(Jedis jedis = pool.getResource()) {
			jedis.set("kristy","zk");
			System.out.println("The key-value is: kristy - " + jedis.get("kristy"));
		}
	}

	public static void testPipiline(JedisPool pool){
		try (Jedis jedis = pool.getResource()){
			Pipeline pipeline = jedis.pipelined();
			for (int i = 1; i < 10; i ++){
				pipeline.set("key" + i, "value" + i);
			}
			pipeline.sync();

			for (int i = 1 ; i < 10; i ++){
				pipeline.get("key" + i);
			}
			List<Object> list =  pipeline.syncAndReturnAll();
			list.forEach(o -> System.out.println(o.toString()));
		}
	}

	public static void testTransaction(JedisPool pool){
		try (Jedis jedis = pool.getResource()){
			Transaction transaction = jedis.multi();
			for (int i = 1; i < 10; i  ++){
				transaction.get("key" + i);
			}

			List<Object> list = transaction.exec();
			list.forEach(o -> System.out.println(o.toString()));
		}
	}
}
