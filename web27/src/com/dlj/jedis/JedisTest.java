package com.dlj.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

	// 获得单一的jedis对象操作数据库
	// @Test
	public void test1() {
		// 1.设置ip地址和端口
		Jedis jedis = new Jedis("192.168.86.3", 6379);
		// 2.获得用户名
		String userName = jedis.get("username");
		System.out.println(userName);
		// 3.存储
		jedis.set("addr", "bejing");
		System.out.println(jedis.get("addr"));
	}

	// 通过jedis的pool获取jedis对象
	@Test
	public void test2() {
		// 0.创建连接池的配置对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxTotal(30);
		// 1.创建一个redis连接池
		JedisPool pool = new JedisPool(poolConfig, "192.168.86.3", 6379);
		// 2.从连接池中获取数据库的连接资源
		Jedis jedis = pool.getResource();
		// 3.操作数据库
		System.out.println(jedis.get("username"));
		// 4.关闭资源
		jedis.close();
	}
}
