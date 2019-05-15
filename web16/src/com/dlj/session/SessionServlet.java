package com.dlj.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建该客户端私有的Session区域
		// 该方法会在内部判断是否已经存在该session对象，如果不存在就创建，已经存在就不创建
		HttpSession session = request.getSession();
		String id = session.getId();// 获取该session对象的ID
		// 创建一个存储JSessionid的cookie对象，并设置持久化时间
		/*
		 * Cookie cookie = new Cookie("JSESSIONID", id);
		 * cookie.setPath("/web16"); cookie.setMaxAge(60 * 10);
		 * response.addCookie(cookie);
		 */
		session.setAttribute("name", "15932179035");
		response.getWriter().write("hello dlj session id:" + id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
