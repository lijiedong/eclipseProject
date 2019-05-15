package com.dlj.service;

import java.sql.SQLException;

import com.dlj.dao.UserDao;

public class UserService {

	public boolean checkUserName(String userName) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		Long count = userDao.checkUserName(userName);
		return count > 0 ? true : false;
	}

}
