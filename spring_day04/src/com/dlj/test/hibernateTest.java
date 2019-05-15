package com.dlj.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlj.dao.UserDao;
import com.dlj.entity.User;
import com.dlj.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class hibernateTest {
	@Resource(name = "sessionFactory")
	private SessionFactory sf;
	@Resource(name = "userDao")
	private UserDao ud;
	@Resource(name = "userService")
	private UserService us;

	@Test
	// 测试aop事务
	public void fun4() {
		User u = new User();
		u.setUsername("java");
		us.saveUser(u);
	}

	// 测试Heibernate模板
	public void fun3() {
		User u = ud.getByUserCode("dlj");
		System.out.println(u.toString());
	}

	// 测试sessionFactory
	public void fun2() {

		Session session = sf.openSession();
		// 4. 开启事务
		Transaction tx = session.beginTransaction();
		// 5. 写具体逻辑crud操作
		// 添加功能
		User user = new User();
		user.setUsername("蔡光！");
		user.setPassword("123sa");
		user.setAddress("哥伦比亚共和国sa");
		// 调用sesion中的方法实现添加
		session.save(user);
		// 6. 提交事务
		tx.commit();
		// 7. 关闭资源
		session.close();

	}

	// 单独测试hibernate
	public void fun1() {
		// 1. 加载hibernate核心配置文件
		// hibernate里面封装了一个Configuration对象用来加载核心配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		// 2. 创建SessionFactory对象
		// 读取hibernate核心配置文件内容，创建sessionFactory
		// 在这个过程里，根据映射关系，把数据库里相应的表创建
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 3. 使用SessionFactory创建session对象
		// 类似于jdbc中的连接
		Session session = sessionFactory.openSession();
		// 4. 开启事务
		Transaction tx = session.beginTransaction();
		// 5. 写具体逻辑crud操作
		// 添加功能
		User user = new User();
		user.setUsername("张三ss");
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
}
