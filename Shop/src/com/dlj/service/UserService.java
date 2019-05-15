package com.dlj.service;

import java.sql.SQLException;

import com.dlj.dao.UserDao;
import com.dlj.domain.User;

public class UserService {

	public Boolean register(User user) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		int row = 0;
		try {
			row = dao.register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row > 0 ? true : false;
	}

	public void active(String activeCode) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		dao.active(activeCode);
	}

	public boolean checkUserName(String username) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		long row = dao.checkUserName(username);
		return row > 0 ? true : false;
	}

	// 用户登录的方法
	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username, password);
	}

}
