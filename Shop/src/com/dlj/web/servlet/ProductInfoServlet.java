package com.dlj.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.domain.Product;
import com.dlj.web.service.ProductService;

public class ProductInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		// 获得当前页和商品类别，为了商品信息列表返回到之前的页面
		String currentPage = request.getParameter("currentPage");
		String cid = request.getParameter("cid");
		request.setAttribute("product", product);
		//
		request.setAttribute("cid", cid);
		request.setAttribute("currentPage", currentPage);
		// 获得客户端携带cookie---获得名字是pids的cookie
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("pids".equals(cookie.getName())) {
					pids = cookie.getValue();
					// 1-3-2 本次访问商品pid是8----->8-1-3-2
					// 1-3-2 本次访问商品pid是3----->3-1-2
					// 1-3-2 本次访问商品pid是2----->2-1-3
					// 将pids拆成一个数组
					String[] split = pids.split("-");// {3,1,2}
					List<String> asList = Arrays.asList(split);// [3,1,2]
					LinkedList<String> list = new LinkedList<String>(asList);// [3,1,2]
					// 判断集合中是否存在当前pid
					if (list.contains(pid)) {
						// 包含当前查看商品的pid
						list.remove(pid);
						list.addFirst(pid);
					} else {
						// 不包含当前查看商品的pid 直接将该pid放到头上
						list.addFirst(pid);
					}
					// 将[3,1,2]转成3-1-2字符串
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < list.size() && i < 7; i++) {
						sb.append(list.get(i));
						sb.append("-");// 3-1-2-
					}
					// 去掉3-1-2-后的-
					pids = sb.substring(0, sb.length() - 1);
				}
			}
		}

		Cookie cookie_pids = new Cookie("pids", pids);
		response.addCookie(cookie_pids);
		request.getRequestDispatcher("product_info.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}