package com.dlj.service;

import java.sql.SQLException;
import java.util.List;

import com.dlj.dao.AdminProductDao;
import com.dlj.domain.Category;
import com.dlj.domain.Product;
import com.dlj.vo.Condition;

public class AdminProductService {

	public List<Product> findAllProductService() throws SQLException {
		AdminProductDao dao = new AdminProductDao();

		return dao.findAllProductDao();
	}

	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		// TODO Auto-generated method stub
		return dao.findAllCategory();
	}

	public void addProductService(Product pro) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductDao dao = new AdminProductDao();
		dao.addProductDao(pro);
	}

	public void delProductByIDService(String pid) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductDao dao = new AdminProductDao();
		dao.delProductByIDDao(pid);
	}

	public Product findProductById(String pid) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductByIdDao(pid);

	}

	public void updateProductService(Product pro) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductDao dao = new AdminProductDao();
		dao.updateProductDao(pro);
	}

	public List<Product> findProductByConditionSer(Condition condition) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductByConditionDao(condition);

	}

}
