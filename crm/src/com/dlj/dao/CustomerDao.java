package com.dlj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dlj.entity.Customer;
import com.dlj.entity.LinkMan;
import com.dlj.utils.HibernateUtils;

public class CustomerDao {

	public void save(Customer c) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		// 3 开启事务
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

		}
	}

	public List<Customer> getAllCustomerList() {
		// TODO Auto-generated method stub
		// 获得session

		List<Customer> list = null;
		Session session = HibernateUtils.getSessionobject();

		Query query = session.createQuery("from Customer");
		list = query.list();

		return list;
	}

	public void addLinkMan(LinkMan lm) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionobject();
		Customer c = session.get(Customer.class, (long) 1);
		c.getLinkMens().add(lm);
		lm.setCustomer(c);
		session.save(c);
	}

	public List<Customer> getAllCustomerList(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		List<Customer> list = null;
		Session session = HibernateUtils.getSessionobject();
		// 将离线对象关联到session
		Criteria c = dc.getExecutableCriteria(session);

		return c.list();
	}

}
