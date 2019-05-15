package com.dlj.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dlj.entity.User;
import com.dlj.utils.HibernateUtils;

public class UserDao {

	public User getByUserName(String username) {
		// TODO Auto-generated method stub
		// 1获得session
		Session session = HibernateUtils.getSessionobject();
		// 2书写HQL
		String hql = "from User where username=?";
		// 3 创建查询对象
		Query query = session.createQuery(hql);
		// 4 设置参数
		query.setParameter(0, username);
		// 5执行查询
		User user = (User) query.uniqueResult();
		return user;
	}

}
