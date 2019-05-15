package com.dlj.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.dlj.entity.User;

public class MyBatisFirstTest {
	@Test
	// 通过用户名称模糊查询用户
	public void testFindUserByUseerName() throws IOException {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行Sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);

		System.out.println(user);
	}

	// 通过用户名查询用户
	public void testMyBatis() throws IOException {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行Sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);

		System.out.println(user);
	}
}
