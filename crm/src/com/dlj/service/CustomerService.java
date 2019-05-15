package com.dlj.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dlj.dao.CustomerDao;
import com.dlj.entity.Customer;
import com.dlj.entity.LinkMan;
import com.dlj.utils.HibernateUtils;

public class CustomerService {
	private CustomerDao dao;

	public void save(Customer c) {
		// TODO Auto-generated method stub

		dao.save(c);
	}

	public List<Customer> getAllCustomerList() {

		Session session = null; // 3 开启事务 Transaction tx = null;
		List<Customer> list = null;
		Transaction tx = null;
		try {

			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
			list = dao.getAllCustomerList();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;

	}

	public void addLinkMan(LinkMan lm) {
		// TODO Auto-generated method stub
		Session session = null; // 3 开启事务 Transaction tx = null;
		Transaction tx = null;
		try {

			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
			dao.addLinkMan(lm);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	public List<Customer> getAllCustomerList(DetachedCriteria dc) {
		// TODO Auto-generated method stub

		Session session = null; // 3 开启事务 Transaction tx = null;
		List<Customer> list = null;
		Transaction tx = null;
		try {

			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
			list = dao.getAllCustomerList(dc);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

}
