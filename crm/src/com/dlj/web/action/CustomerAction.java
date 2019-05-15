package com.dlj.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dlj.entity.Customer;
import com.dlj.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public String add() throws Exception {
		// 1调用service
		CustomerService service = new CustomerService();
		service.save(customer);
		// 2重定向到列表action方法

		return "toList";
	}

	public String list() throws Exception {
		// TODO Auto-generated method stub
		// 1获得ServletContext对象
		ServletContext sc = ServletActionContext.getServletContext();
		/// 1.从ServletContext中获得容器
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		CustomerService ser = (CustomerService) ac.getBean("customerService");
		// ================================
		// 1接收参数
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		// 2 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 3 判断参数拼接
		if (cust_name != null && !"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}
		// 1 调用service查询所有客户
		CustomerService service = new CustomerService();
		// 2 将客户列表放到request域
		List<Customer> list = ser.getAllCustomerList(dc);
		ActionContext.getContext().put("list", list);
		// ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}
