package com.dlj.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dlj.domain.Category;
import com.dlj.domain.Product;
import com.dlj.service.AdminProductService;
import com.dlj.vo.Condition;

public class AdminSearchProductList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.收集表单数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		// 2.将散装的数据封装到vo实体中去
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.将实体传递到Service层
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		try {
			productList = service.findProductByConditionSer(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		// 显示类别列表
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("Condition", condition);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		// response.getWriter().write("hello dlj");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}