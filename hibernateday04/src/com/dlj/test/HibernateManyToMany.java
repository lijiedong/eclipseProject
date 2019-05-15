package com.dlj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dlj.manytomany.Role;
import com.dlj.manytomany.User;
import com.dlj.utils.HibernateUtils;

public class HibernateManyToMany {
	@Test
	// 演示维护第三张表
	public void tesMaintainDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/*
			 * // 让某个用户有某个角色 // 让lucy有保安角色 User lucy = session.get(User.class,
			 * 1); Role role = session.get(Role.class, 3); // 把角色放到用户的set集合里
			 * lucy.getSetRole().add(role);
			 */
			// 让某个用户没有某个角色
			// 让lucy没有保安角色
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			lucy.getSetRole().remove(role);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	// 演示多对多级联保存
	public void testUpdateDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 添加两个用户，为每个用户添加两个角色
			// 1.创建对象
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123");
			User user2 = new User();
			user2.setUser_name("mary");
			user2.setUser_password("456");
			Role r1 = new Role();
			r1.setRole_name("总经理");
			r1.setRole_memo("总经理");
			Role r2 = new Role();
			r2.setRole_name("秘书");
			r2.setRole_memo("秘书");
			Role r3 = new Role();
			r3.setRole_name("保安");
			r3.setRole_memo("保安");
			// 2.建立关系，把角色放到用户里面
			// user1----r1/r2
			user1.getSetRole().add(r1);
			user1.getSetRole().add(r2);
			// user2---r2/r3
			user2.getSetRole().add(r2);
			user2.getSetRole().add(r3);
			// 3 保存用户
			session.save(user1);
			session.save(user2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
