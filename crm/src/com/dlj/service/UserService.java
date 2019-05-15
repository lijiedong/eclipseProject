package com.dlj.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dlj.dao.UserDao;
import com.dlj.entity.User;
import com.dlj.utils.HibernateUtils;

public class UserService {
	private UserDao dao = new UserDao();

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public User loginin(User user) {
		// TODO Auto-generated method stub
		Session session = null; // 3 开启事务 Transaction tx = null;
		Transaction tx = null;
		User u = null;
		try {

			session = HibernateUtils.getSessionobject();

			tx = session.beginTransaction();
			// 1.调用Dao根据登陆名称查询User对象

			u = dao.getByUserName(user.getUsername());

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		// 获得不到，抛出异常提示用户名不存在
		if (u == null) {
			throw new RuntimeException("用户名不存在！");
		}
		// 2.比对密码是否一致
		if (!u.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("密码错误！");
		}
		// 不一致，抛出异常，提示密码错误
		// 3.将数据库查询到的User返回
		return u;
	}

}
