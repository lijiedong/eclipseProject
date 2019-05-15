package com.dlj.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration cfg;
	// 2. 创建SessionFactory对象
	// 读取hibernate核心配置文件内容，创建sessionFactory
	// 在这个过程里，根据映射关系，把数据库里相应的表创建
	private static final SessionFactory sessionFactory;
	static {
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	// 获得session的方法
	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
