package com.dlj.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dlj.domain.Product;
import com.dlj.utils.DataSourceUtils;

public class ProductDao {
	public List<Product> findAllProducts() throws SQLException {
		// 操作数据库查询数据
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}
}
