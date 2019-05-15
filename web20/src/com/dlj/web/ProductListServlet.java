package com.dlj.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.Product;
import com.dlj.service.ProductService;
import com.dlj.vo.PageBean;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();
		/*
		 * List<Product> productList = null; try { productList =
		 * service.findAllProductSer(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * request.setAttribute("productList", productList);
		 */
		// 模拟数据
		// 模拟当前是第一页
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		// 认为每页显示12条
		int currentCount = 12;

		PageBean<Product> pageBean = null;
		try {
			pageBean = service.findPageBeanSer(currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}