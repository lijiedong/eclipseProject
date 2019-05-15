package com.dlj.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlj.domain.User;
import com.dlj.web.service.UserService;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 获得cookies
		// 定义cookie_username，cookie_password
		String cookie_password = null;
		String cookie_username = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cook : cookies) {
				// 获得存储用户名和密码的cookie
				if ("cookie_username".equals(cook.getName())) {
					cookie_username = cook.getValue();
				}
				if ("cookie_password".equals(cook.getName())) {
					cookie_password = cook.getValue();
				}
			}
		}
		// 如果获得的用户名和密码不为空则进行登陆
		if (cookie_username != null && cookie_password != null) {
			System.out.println("用户名和密码不为空");
			HttpSession session = req.getSession();
			UserService service = new UserService();
			User user = null;
			try {
				user = service.login(cookie_username, cookie_password);
				System.out.println("filter user is not null!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session.setAttribute("user", user);

		}
		// 放行
		chain.doFilter(req, res);
		System.out.println("filter is running!");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
