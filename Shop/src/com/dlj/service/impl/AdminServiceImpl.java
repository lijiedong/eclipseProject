package com.dlj.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlj.dao.AdminDao;
import com.dlj.domain.Category;
import com.dlj.domain.Order;
import com.dlj.domain.Product;
import com.dlj.service.AdminService;

public class AdminServiceImpl implements AdminService {
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		try {
			return dao.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void addProduct(Product pro) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		try {
			dao.addProduct(pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		try {
			return dao.findAllOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();

		try {
			return dao.findOrderInfoByOid(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
