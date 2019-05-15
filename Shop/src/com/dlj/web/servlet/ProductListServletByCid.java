package com.dlj.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.PageBean;
import com.dlj.domain.Product;
import com.dlj.web.service.ProductService;

public class ProductListServletByCid extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取类别ID
		String cid = request.getParameter("cid");
		ProductService service = new ProductService();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null) {
			currentPageStr = "1";
		}
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 12;
		PageBean pageBean = null;
		try {
			pageBean = service.finProductListByCid(cid, currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);
		// 定义一个记录历史商品信息的集合
		List<Product> historyProductList = new ArrayList<Product>();

		// 获得客户端携带名字叫pids的cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("pids".equals(cookie.getName())) {
					String pids = cookie.getValue();// 3-2-1
					String[] split = pids.split("-");
					for (String pid : split) {
						Product pro = service.findProductByPid(pid);
						historyProductList.add(pro);
					}
				}
			}
		}

		// 将历史记录的集合放到域中
		request.setAttribute("historyProductList", historyProductList);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}