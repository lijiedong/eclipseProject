package com.dlj.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.dlj.transfer.dao.TransferDao;
import com.dlj.utils.DataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, Double money) {
		boolean flag = true;
		TransferDao dao = new TransferDao();
		Connection conn = null;
		// 转出钱
		try {
			conn = DataSourceUtils.getConnection();
			// 开启事务,必须得是同一个connection对象,所以要参数传递过去
			conn.setAutoCommit(false);
			dao.out(conn, out, money);
			// 转入钱
			dao.in(conn, in, money);

		} catch (SQLException e) {
			flag = false;
			// 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}
}
