package com.dlj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dlj.entity.Customer;
import com.dlj.service.CustomerService;

public class CustomerListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 判断查询条件
		// 判断查询条件是否为空
		String cust_name = request.getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);

		if (cust_name != null && !"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}

		// 1 调用service查询所有客户
		CustomerService service = new CustomerService();
		// 2 将客户列表放到request域
		List<Customer> list = service.getAllCustomerList(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}