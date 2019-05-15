package com.dlj.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dlj.domain.Product;
import com.dlj.service.AdminProductService;

public class AdminUpdateProduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得前台传过来的数据
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Product pro = new Product();
		try {
			BeanUtils.populate(pro, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro.setPimage("products/1/c_0001.jpg");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = format.format(new Date());
		pro.setPdate(pdate);
		pro.setPflag(0);
		AdminProductService service = new AdminProductService();
		try {
			service.updateProductService(pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/adminProductListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}