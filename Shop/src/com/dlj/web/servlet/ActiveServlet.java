package com.dlj.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.service.UserService;

public class ActiveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得激活码
		String activeCode = request.getParameter("activeCode");
		UserService service = new UserService();
		try {
			service.active(activeCode);
			// 激活成功跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().write("there is something wrong！");
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}