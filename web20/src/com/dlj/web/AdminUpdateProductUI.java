package com.dlj.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.Category;
import com.dlj.domain.Product;
import com.dlj.service.AdminProductService;

public class AdminUpdateProductUI extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 首先获取传递过来的pid
		String pid = request.getParameter("pid");
		//
		AdminProductService service = new AdminProductService();
		Product pro = null;
		try {
			pro = service.findProductById(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获得商品的类别列表
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("product", pro);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		response.getWriter().write("hello dlj");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
