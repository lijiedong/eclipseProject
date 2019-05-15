package com.dlj.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得客户端携带的cookie数据
		Cookie[] cookies = request.getCookies();
		String str = "";
		// 2.通过cookie的name属性获得值
		for (Cookie cookie : cookies) {
			if ("name".equals(cookie.getName())) {
				str = "获得Cookie成功!";
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("hello dlj" + str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
