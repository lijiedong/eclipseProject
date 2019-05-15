package com.dlj.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class TransferDao {
	public void out(Connection conn, String out, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// Connection conn = DataSourceUtils.getConnection();
		String sql = "update account set money=money-? where account=?";
		runner.update(conn, sql, money, out);
	}

	public void in(Connection conn, String in, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// Connection conn = DataSourceUtils.getConnection();
		String sql = "update account set money=money+? where account=?";
		runner.update(conn, sql, money, in);

	}
}
