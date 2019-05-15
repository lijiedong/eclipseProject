package com.dlj.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dlj.utils.HibernateUtils;

public class HibernateMany {
	@Test
	public void testSelect1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1 创建query对象
			Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan ");
			List list = query.list();

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
