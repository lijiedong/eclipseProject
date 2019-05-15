package com.dlj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 通过jdbc去控制事务
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获得connection
		Connection conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "dre@mtech1012");
		// 3.获得执行平台
		Statement stmt = conn.createStatement();
		// 4.执行sql
		stmt.executeUpdate("insert into account values(null,'tom1',3000)");
		stmt.close();
		conn.close();
	}
}
