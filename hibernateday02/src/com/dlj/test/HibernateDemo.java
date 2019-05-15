package com.dlj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.dlj.entity.User;
import com.dlj.utils.HibernateUtils;

public class HibernateDemo {
	// 测试事务
	@Test
	public void test() {

		System.out.println("--");
	}

	public void testTX() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User user = new User();
			user.setUsername("小马");
			user.setPassword("sdgag");
			user.setAddress("非洲");
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

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
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setAddress("哥伦比亚共和国");
		// 调用sesion中的方法实现添加
		session.save(user);
		// 6. 提交事务
		tx.commit();
		// 7. 关闭资源
		session.close();
		sessionFactory.close();
	}

	public void testCach() {
		// 1 调用工具类，得到sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 2 获取session
		Session session = sessionFactory.openSession();
		// 3 开启事务
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 4);
		user.setAddress("33333");

		tx.commit();
		// 6 关闭资源
		session.close();
		sessionFactory.close();
	}

	public void testSaveOrUpdate() {
		// 1 调用工具类，得到sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 2 获取session
		Session session = sessionFactory.openSession();
		// 3 开启事务
		Transaction tx = session.beginTransaction();

		// User user = new User();
		//
		// user.setAddress("美国1");
		// user.setPassword("1231");
		// user.setUsername("破马张飞1");
		User user = session.get(User.class, 4);
		user.setUsername("sssss");
		session.saveOrUpdate(user);
		tx.commit();
		// 6 关闭资源
		session.close();
		sessionFactory.close();
	}

	public void testDelete() {
		// 1 调用工具类，得到sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 2 获取session
		Session session = sessionFactory.openSession();
		// 3 开启事务
		Transaction tx = session.beginTransaction();
		// 4 删除操作
		// 第一种根据id查询对象
		// User user = session.get(User.class, 1);
		// session.delete(user);
		// 第二种新建一个user对象
		User user = new User();
		user.setUid(2);
		session.delete(user);
		tx.commit();
		// 6 关闭资源
		session.close();
		sessionFactory.close();
	}

	public void testUpdate() {
		// 1 调用工具类，得到sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 2 获取session
		Session session = sessionFactory.openSession();
		// 3 开启事务
		Transaction tx = session.beginTransaction();
		// 4 修改操作
		// 先查询，然后再进行修改
		// 调用session里面的get方法，第一参数：实体类的字节码对象，第二个参数：id值
		User user = session.get(User.class, 1);
		user.setUsername("王张飞as");
		session.save(user);
		System.out.println(user);
		tx.commit();
		// 6 关闭资源
		session.close();
		sessionFactory.close();
	}

	public void testGet() {
		// 1 调用工具类，得到sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 2 获取session
		Session session = sessionFactory.openSession();
		// 3 开启事务
		Transaction tx = session.beginTransaction();
		// 4 根据id查询
		// 调用session里面的get方法，第一参数：实体类的字节码对象，第二个参数：id值
		User user = session.get(User.class, 1);
		System.out.println(user);
		tx.commit();
		// 6 关闭资源
		session.close();
		sessionFactory.close();
	}
}
