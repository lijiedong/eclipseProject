package com.dlj.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1。创建cookie对象
		Cookie cookie = new Cookie("name", "zhangsan");
		// 1.1设置cookie的持久化时间
		cookie.setMaxAge(120);
		// 2、将cookie中存储的信息发送到客户端---头
		cookie.setPath("/web16");
		response.addCookie(cookie);
		response.getWriter().write("hello dlj");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}