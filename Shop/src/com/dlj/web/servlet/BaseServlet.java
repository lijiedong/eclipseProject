package com.dlj.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 1.获得请求的method名称
			req.setCharacterEncoding("UTF-8");
			String methodName = req.getParameter("method");

			// 2.获得被访问的对象的字节码对象
			System.out.println("###");
			Class clazz = this.getClass();
			System.out.println(methodName);
			// 3.获得当前字节码对象中的指定方法
			Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}