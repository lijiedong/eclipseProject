package com.dlj.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg;
	// 2. 创建SessionFactory对象
	// 读取hibernate核心配置文件内容，创建sessionFactory
	// 在这个过程里，根据映射关系，把数据库里相应的表创建
	private static SessionFactory sessionFactory;
	static {
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	// 提供返回与本地线程帮的session的方法
	public static Session getSessionobject() {
		return sessionFactory.getCurrentSession();
	}

	// 提供方法返回sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
