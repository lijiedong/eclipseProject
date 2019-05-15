package com.learn.chapter2.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	// SqlSessionFactory对象
	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis-config.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			// 创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			System.out.println("sdff");
		}
		return sqlSessionFactory.openSession();
	}

}
