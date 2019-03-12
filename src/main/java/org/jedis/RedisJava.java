package org.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
		pool.close();

	}

	public static void testString(JedisPool pool){
		try(Jedis jedis = pool.getResource()) {
			jedis.set("kristy","zk");
			System.out.println("The key-value is: kristy - " + jedis.get("kristy"));
		}
	}
}
