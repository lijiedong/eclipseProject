package cn.itheima.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class testDButils {
	@Test
	public void testAddUser(){
		QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
		String sql="insert into tb_user values(null,?,?)";
		Object[] para={"query","querymima"};
		int rows;
		try {
			rows = qr.update(sql, para);
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
