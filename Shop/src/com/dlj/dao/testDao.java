package com.dlj.dao;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;

import com.dlj.domain.User;
import com.dlj.utils.DataSourceUtils;

public class testDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		User user = new User();
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		user.setUid(UUID.randomUUID().toString());
		try {
			int update = runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(),
					user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(),
					user.getCode());
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
