package com.dlj.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dlj.domain.Product;
import com.dlj.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAllProductDao() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product;";
		List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return products;
	}

	// 获得全部商品的条数
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long query = runner.query(sql, new ScalarHandler<>());
		return query.intValue();
	}

	public List<Product> findProductListForPageBean(int index, int currentCount) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
	}

}
