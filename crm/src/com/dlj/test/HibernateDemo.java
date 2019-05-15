package com.dlj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.dlj.entity.Customer;

public class HibernateDemo {
	@Test
	public void testAdd() {
		// 1. 加载hibernate核心配置文件
		// hibernate里面封装了一个Configuration对象用来加载核心配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		// 2. 创建SessionFactory对象
		// 读取hibernate核心配置文件内容，创建sessionFactory
		// 在这个过程里，根据映射关系，把数据库里相应的表创建
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 3. 使用SessionFactory创建session对象
		// 类似于jdbc中的connection对象
		Session session = sessionFactory.openSession();
		// 4. 开启事务
		Transaction tx = session.beginTransaction();
		// 5. 写具体逻辑crud操作
		// 添加功能
		Customer c = new Customer();
		c.setCust_name("ssss");
		// 调用sesion中的方法实现添加
		session.save(c);
		// 6. 提交事务
		tx.commit();
		// 7. 关闭资源
		session.close();
		sessionFactory.close();
	}

}
