package com.dlj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dlj.domain.Category;
import com.dlj.domain.Product;
import com.dlj.utils.DataSourceUtils;
import com.dlj.vo.Condition;

public class AdminProductDao {

	public List<Product> findAllProductDao() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product;";
		List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return products;
	}

	public List<Category> findAllCategory() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category;";
		List<Category> categories = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return categories;
	}

	public void addProductDao(Product product) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(),
				product.getCid());
	}

	public void delProductByIDDao(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "delete from product where pid=?";
		runner.update(sql, pid);
	}

	public Product findProductByIdDao(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

	public void updateProductDao(Product product) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		runner.update(sql, product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(),
				product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCid(),
				product.getPid());
	}

	public List<Product> findProductByConditionDao(Condition condition) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		// 定义一个容器用于存储参数
		List<String> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder("select * from product where 1=1 ");
		if (condition.getPname() != null && !condition.getPname().trim().equals("")) {
			sql.append(" and  pname like ? ");
			list.add("%" + condition.getPname().trim() + "%");
		}
		if (condition.getIs_hot() != null && !condition.getIs_hot().trim().equals("")) {
			sql.append(" and  is_hot= ?");
			list.add(condition.getIs_hot());
		}
		if (condition.getCid() != null && !condition.getCid().trim().equals("")) {
			sql.append(" and  cid= ?");
			list.add(condition.getCid().trim());
		}
		// List<Product> productList= runner.query(sql, new
		// BeanListHandler<Product>(Product.class),list.toArray());
		List<Product> productList = runner.query(sql.toString(), new BeanListHandler<Product>(Product.class),
				list.toArray());
		return productList;
	}

}
