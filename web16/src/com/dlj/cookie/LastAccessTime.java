package com.dlj.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTime extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得当前时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		System.out.println(currentTime);
		// 1.创建Cookie记录当前的最新的时间
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60 * 60 * 10);
		response.addCookie(cookie);
		// 2获得客户端携带的cookie---lastAccessTime
		Cookie[] cookies = request.getCookies();
		String lastAccessTime = null;
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8");

		if (lastAccessTime == null) {
			response.getWriter().write("hello dlj" + "您是第一次访问！");
		} else {
			response.getWriter().write("hello dlj lastAccessTime" + lastAccessTime);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}