package com.dlj.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlj.domain.User;
import com.dlj.web.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "---" + password);
		HttpSession session = request.getSession();
		UserService service = new UserService();
		User user = null;
		try {
			user = service.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 登陆成功
		if (user != null) {
			// 判断用户是否勾选自动登陆
			String autologin = request.getParameter("autologin");
			if (autologin != null) {
				Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				cookie_username.setMaxAge(60 * 60);
				cookie_password.setMaxAge(60 * 60);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
				System.out.println("添加了cookie");
			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		} else {
			// 失败转发到登陆页面，给出提示信息
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}