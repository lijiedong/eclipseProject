package com.dlj.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dlj.domain.User;
import com.dlj.utils.DataSourceUtils;

public class UserDao {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User query = runner.query(sql, new BeanHandler<User>(User.class), username, password);
		return query;
	}

}
