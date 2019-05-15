package com.dlj.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dlj.entity.Customer;
import com.dlj.utils.HibernateUtils;

public class HibernateDemo {

	@Test
	// 演示条件查询
	public void testSelect2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/*
			 * // 查询cid=2的客户，再查询这个客户的所有联系人 Customer customer =
			 * session.get(Customer.class, 2); // 查询到客户以后，直接得到联系人里面的set集合
			 * Set<LinkMan> linkmans = customer.getSetLinkMan();
			 * System.out.println(linkmans.size());
			 */
			// hql查询
			/*
			 * //1. 创建 Query query = session.createQuery("from Customer "); //
			 * 设置分页数据 // 2.1 设置开始位置 query.setFirstResult(0);
			 * query.setMaxResults(3); List<Customer> list = query.list(); for
			 * (Customer customer : list) { System.out.println(customer.getCid()
			 * + "---" + customer.getCustName()); }
			 */
			Query query = session.createQuery("select count(*) from Customer ");
			// 调用方法得到结果
			// query对象里面有方法，直接返回对象形式
			Object obj = query.uniqueResult();
			System.out.println(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	// 演示对象查询
	public void testSelect1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/*
			 * // 查询cid=2的客户，再查询这个客户的所有联系人 Customer customer =
			 * session.get(Customer.class, 2); // 查询到客户以后，直接得到联系人里面的set集合
			 * Set<LinkMan> linkmans = customer.getSetLinkMan();
			 * System.out.println(linkmans.size());
			 */
			// hql查询
			// 1 创建Query对象，写hql语句
			// 2 调用query对象里的方法得到结果
			Query query = session.createQuery("from Customer");
			// 2.调用方法得到结果
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + "---" + customer.getCustName());
			}
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
