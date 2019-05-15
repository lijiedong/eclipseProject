package com.dlj.service;

import java.sql.SQLException;
import java.util.List;

import com.dlj.dao.ProductDao;
import com.dlj.domain.Product;

public class ProductService {
	public List<Product> findAllProducts() throws SQLException {
		return new ProductDao().findAllProducts();
	}
}
