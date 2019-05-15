package com.dlj.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.Category;
import com.dlj.domain.Order;
import com.dlj.service.AdminService;
import com.dlj.utils.BeanFactory;
import com.google.gson.Gson;

public class AdminServlet extends BaseServlet {
	// 更具订单id查询订单项和商品信息
	public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得oid
		String oid = request.getParameter("oid");
		// 使用解耦合的方式进行编码
		// 使用工厂+反射+配置文件
		AdminService service = (AdminService) BeanFactory.getBean("adminService");
		List<Map<String, Object>> map = service.findOrderInfoByOid(oid);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(json);
		response.getWriter().write(json);
	}

	// 获得所有订单
	public void findAllOrders(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminService service = (AdminService) BeanFactory.getBean("adminService");
		List<Order> orderList = service.findAllOrders();
		request.setAttribute("orderList", orderList);

		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
	}

	// 获得所有类别
	public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AdminService service = (AdminService) BeanFactory.getBean("adminService");
		List<Category> categoryList = service.findAllCategory();
		Gson gson = new Gson();
		String json = gson.toJson(categoryList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
}