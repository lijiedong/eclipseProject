package com.dlj.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置request的编码---只适合post方式
		request.setCharacterEncoding("UTF-8");

		// get方式乱码解决
		// String username = request.getParameter("username");//乱码
		// 先用iso8859-1编码 在使用utf-8解码
		// username = new String(username.getBytes("iso8859-1"),"UTF-8");

		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		// 使用BeanUtils将数组导入到Bean中
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 手动添加uid,生成一个随机字符串
		user.setUid(UUID.randomUUID().toString());
		// 操作数据库
		try {
			register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 注册的方法
	public void register(User user) throws SQLException {
		// 操作数据库
		// 操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

		runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), null,
				user.getBirthday(), user.getSex(), null, null);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}