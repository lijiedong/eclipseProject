package com.dlj.web.service;

import java.sql.SQLException;

import com.dlj.dao.UserDao;
import com.dlj.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		User user = dao.login(username, password);
		return user;
	}

}
