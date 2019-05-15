package com.dlj.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.Category;
import com.dlj.web.service.ProductService;
import com.google.gson.Gson;

public class CategoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService service = new ProductService();
		// 先从redis缓存中查询categoryList,如果有直接使用，没有再从数据库中查询

		// 获取所有类别
		List<Category> categoryList = service.findAllCategory();
		Gson gson = new Gson();

		String json = gson.toJson(categoryList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}