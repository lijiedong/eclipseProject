package com.dlj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.dlj.entity.Customer;
import com.dlj.entity.LinkMan;
import com.dlj.utils.HibernateUtils;

public class HibernateOneToMany {
	@Test
	public void testUpdateDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1.先根据id查找联系人lucy，再根据id查找客户百度
			Customer customer = session.get(Customer.class, 2);
			LinkMan lucy = session.get(LinkMan.class, 3);
			// 2 设置持久态对象值
			// 把联系人放到客户里面
			customer.getSetLinkMan().add(lucy);
			lucy.setCustomer(customer);
			// 把客户放到联系人里面

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public void testDeleteDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1.根据id查询客户对象
			Customer customer = session.get(Customer.class, 1);
			session.delete(customer);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	// 一对多级联保存的简化操作
	public void testAddDemo2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1.创建联系人和客户对象
			Customer customer = new Customer();
			customer.setCustName("百度");
			customer.setCustLevel("vip0110");
			customer.setCustSource("网络0110");
			customer.setCustPhone("0110110");
			customer.setCustMobile("9990110");
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("lucy");
			linkMan.setLkm_gender("男011");
			linkMan.setLkm_phone("901111");
			// 2 在客户表示所有联系人，在联系人里表示客户
			// 2.1 把联系人对象放到客户对象的set集合里面
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			// 3.保存到数据库
			session.save(customer);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	// 一对多级联保存

	public void testAddDemo1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1.创建联系人和客户对象
			Customer customer = new Customer();
			customer.setCustName("传智播客");
			customer.setCustLevel("vip");
			customer.setCustSource("网络");
			customer.setCustPhone("110");
			customer.setCustMobile("999");
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("lucy");
			linkMan.setLkm_gender("男");
			linkMan.setLkm_phone("911");
			// 2 在客户表示所有联系人，在联系人里表示客户
			// 2.1 把联系人对象放到客户对象的set集合里面
			customer.getSetLinkMan().add(linkMan);
			// 2.2把客户对象放到联系人里面
			linkMan.setCustomer(customer);
			// 3.保存到数据库
			session.save(customer);
			session.save(linkMan);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
