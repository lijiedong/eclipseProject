package com.dlj.a_jdbctemplate;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlj.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//演示jdbc模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name = "userDao")
	private UserDao ud;

	public void fun3() {
		User u = new User();
		u.setUid(1);
		u.setUserName("哈哈哈哈ss");
		u.setPassword("gagg22");
		u.setAddress("asdff");
		ud.update(u);
	}

	@Test
	public void fun2() {
		User u = new User();
		u.setUserName("哈显赫");
		u.setPassword("gaggg");
		u.setAddress("asdff");
		ud.save(u);
	}

	public void fun1() throws PropertyVetoException {
		// 0 准备连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate_32");
		dataSource.setUser("root");
		dataSource.setPassword("dre@mtech1012");
		// 1 创建JDBC模板对象
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		// 2 书写sql，并执行
		String sql = "insert into t_user values(null,123,123,null)";
		jt.update(sql);
	}
}
