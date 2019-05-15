package com.dlj.web.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlj.dao.ProductDao;
import com.dlj.domain.Category;
import com.dlj.domain.Order;
import com.dlj.domain.PageBean;
import com.dlj.domain.Product;
import com.dlj.utils.DataSourceUtils;

public class ProductService {

	public List<Product> findHotProductList() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Product> hotProductList = null;
		try {
			hotProductList = dao.findHotProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotProductList;
	}

	public List<Product> findNewProductList() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Product> newProductList = null;
		try {
			newProductList = dao.findNewProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newProductList;
	}

	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Category> categoryList = null;
		try {
			categoryList = dao.findALlCaregory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	public PageBean finProductListByCid(String cid, int currentPage, int currentCount) throws SQLException {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		PageBean<Product> pageBean = new PageBean<Product>();

		// 封装当前页
		pageBean.setCurrentPage(currentPage);
		// 封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		// 封装总条数
		int totalCount = dao.getCount(cid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 当前页显示的数据

		// select * from product where cid=? limit ?,?
		// 当前页与起始索引index的关系
		int index = (currentPage - 1) * currentCount;
		List<Product> list = null;
		try {
			list = dao.findProductByPage(cid, index, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setList(list);

		return pageBean;
	}

	public Product findProductByPid(String pid) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		Product pro = null;
		try {
			pro = dao.findProdcutByPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	// 提交订单到数据库中
	public void submitOrder(Order order) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		try {
			// 1.开启事务
			DataSourceUtils.startTransaction();
			// 2.调用dao存储Order表存储数据的方法
			dao.addOrders(order);
			// 3.调用dao存储订单项数据
			dao.addOrderItem(order);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void updateOrderAddr(Order order) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		try {
			dao.updateOrderAddr(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Order> findAllOrders(String uid) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Order> findAllOrders = null;
		try {
			findAllOrders = dao.findAllOrders(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findAllOrders;
	}

	public List<Map<String, Object>> findAllOrderItemByOid(String oid) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Map<String, Object>> findAllOrderItemByOid = null;
		try {
			findAllOrderItemByOid = dao.findAllOrderItemByOid(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findAllOrderItemByOid;
	}

}
