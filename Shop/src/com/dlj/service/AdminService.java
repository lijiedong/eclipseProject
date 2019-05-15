package com.dlj.service;

import java.util.List;
import java.util.Map;

import com.dlj.domain.Category;
import com.dlj.domain.Order;
import com.dlj.domain.Product;

public interface AdminService {

	public List<Category> findAllCategory();

	public void addProduct(Product pro);

	public List<Order> findAllOrders();

	public List<Map<String, Object>> findOrderInfoByOid(String oid);

}
