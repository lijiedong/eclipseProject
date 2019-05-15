package com.dlj.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dlj.dao.UserDao;
import com.dlj.entity.User;
import com.dlj.service.UserService;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	@Override
	public User getUserByCodePassword(User u) {
		// TODO Auto-generated method stub
		System.out.println("getUserByCodePassword");
		return null;
	}

	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		ud.saveUser(u);
	}

}
