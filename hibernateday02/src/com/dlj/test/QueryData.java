package com.dlj.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dlj.entity.User;
import com.dlj.utils.HibernateUtils;

public class QueryData {
	@Test
	public void testSqlQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			sqlQuery.addEntity(User.class);
			List<User> list = sqlQuery.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public void testCriteria() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public void testQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
