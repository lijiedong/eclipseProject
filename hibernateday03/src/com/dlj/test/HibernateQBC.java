package com.dlj.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;

import com.dlj.entity.Customer;
import com.dlj.utils.HibernateUtils;

public class HibernateQBC {

	@Test
	// 演示QBC
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
			 * //查询所有 // 1创建对象 Criteria criteria =
			 * session.createCriteria(Customer.class); // 2 调用方法得到结果
			 * List<Customer> list = criteria.list(); for (Customer customer :
			 * list) { System.out.println(customer.getCid() + "---" +
			 * customer.getCustName()); }
			 */
			// 1创建对象
			/*
			 * Criteria criteria = session.createCriteria(Customer.class); // 2
			 * 使用criteria对象里面的方法设置条件值 // 首先使用add方法，表示设置条件值，在add方法里面使用类的方法实现条件设置
			 * criteria.add(Restrictions.eq("cid", 3));
			 * criteria.add(Restrictions.eq("custName", "百度")); // 2 调用方法得到结果
			 * List<Customer> list = criteria.list();
			 */
			/*
			 * Criteria criteria = session.createCriteria(Customer.class); //
			 * 设置对哪个属性进行排序，设置排序规则 criteria.addOrder(Order.asc("cid"));
			 * List<Customer> list = criteria.list();
			 */
			/*
			 * Criteria criteria = session.createCriteria(Customer.class); //
			 * 设置分页数据 // 设置开始位置 criteria.setFirstResult(0); // 每页显示记录数
			 * criteria.setMaxResults(3); List<Customer> list = criteria.list();
			 */
			/*
			 * Criteria criteria = session.createCriteria(Customer.class); //
			 * 设置操作 criteria.setProjection(Projections.rowCount()); Long obj =
			 * (Long) criteria.uniqueResult(); System.out.println(obj);
			 */
			// 1 创建对象
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
			// 最终执行时才需要用到session
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + "----" + customer.getCustName());
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
