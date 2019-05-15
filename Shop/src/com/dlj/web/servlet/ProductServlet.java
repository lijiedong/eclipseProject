package com.dlj.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.dlj.domain.Cart;
import com.dlj.domain.CartItem;
import com.dlj.domain.Category;
import com.dlj.domain.Order;
import com.dlj.domain.OrderItem;
import com.dlj.domain.PageBean;
import com.dlj.domain.Product;
import com.dlj.domain.User;
import com.dlj.utils.CommonUtils;
import com.dlj.web.service.ProductService;
import com.google.gson.Gson;

public class ProductServlet extends BaseServlet {

	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // 获得请求的那个方法的名称 String
	 * methodName = request.getParameter("method"); if
	 * ("getProductByCid".equals(methodName)) { getProductByCid(request,
	 * response); } else if ("categoryList".equals(methodName)) {
	 * categoryList(request, response); } else if ("index".equals(methodName)) {
	 * index(request, response); } else if ("productInfo".equals(methodName)) {
	 * productInfo(request, response); } else {
	 * response.getWriter().write("nothing get! please try again!"); } }
	 * 
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doGet(request,
	 * response); }
	 */

	// 获得我的订单
	public void myOrders(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			// 需要加一个return，否则即使跳转下面的语句也会执行
			return;
		}
		// 查询该用户所有的订单信息(单表查orders)
		ProductService service = new ProductService();
		List<Order> orderList = service.findAllOrders(user.getUid());
		// 循环所有的订单，为每个订单填充订单项
		if (orderList != null) {
			for (Order order : orderList) {
				String oid = order.getOid();
				// 查询该订单的所有的订单项---mapList封装的是多个订单项和该订单项中的商品的信息
				List<Map<String, Object>> mapList = service.findAllOrderItemByOid(oid);
				// 将mapList转换成List<OrderItem> orderItems
				for (Map<String, Object> map : mapList) {

					try {
						// 从map中取出count subtotal 封装到OrderItem中
						OrderItem item = new OrderItem();
						// item.setCount(Integer.parseInt(map.get("count").toString()));
						BeanUtils.populate(item, map);
						// 从map中取出pimage pname shop_price 封装到Product中
						Product product = new Product();
						BeanUtils.populate(product, map);
						// 将product封装到OrderItem
						item.setProduct(product);
						// 将orderitem封装到order中的orderItemList中
						order.getOrderItems().add(item);
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

		// orderList封装完整了
		request.setAttribute("orderList", orderList);

		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}

	// 确认订单,
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, String[]> parameterMap = request.getParameterMap();
		Order order = new Order();

		// 更新收货人地址
		try {
			BeanUtils.populate(order, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductService service = new ProductService();
		// order.setName(new
		// String(request.getParameter("name").getBytes("iso8859-1"), "utf-8"));

		service.updateOrderAddr(order);
		// 2、在线支付
		/*
		 * if(pd_FrpId.equals("ABC-NET-B2C")){ //介入农行的接口 }else
		 * if(pd_FrpId.equals("ICBC-NET-B2C")){ //接入工行的接口 }
		 */
		// .......

		// 只接入一个接口，这个接口已经集成所有的银行接口了 ，这个接口是第三方支付平台提供的
		// 接入的是易宝支付
		// // 获得 支付必须基本数据
		// String orderid = request.getParameter("oid");
		// // String money = order.getTotal()+"";//支付金额
		// String money = "0.01";// 支付金额order.getTotal
		// // 银行
		// String pd_FrpId = request.getParameter("pd_FrpId");
		//
		// // 发给支付公司需要哪些数据
		// String p0_Cmd = "Buy";
		// String p1_MerId =
		// ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		// String p2_Order = orderid;
		// String p3_Amt = money;
		// String p4_Cur = "CNY";
		// String p5_Pid = "";
		// String p6_Pcat = "";
		// String p7_Pdesc = "";
		// // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// // 第三方支付可以访问网址
		// String p8_Url =
		// ResourceBundle.getBundle("merchantInfo").getString("callback");
		// String p9_SAF = "";
		// String pa_MP = "";
		// String pr_NeedResponse = "1";
		// // 加密hmac 需要密钥
		// String keyValue =
		// ResourceBundle.getBundle("merchantInfo").getString("keyValue");
		// String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order,
		// p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
		// p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		//
		// String url =
		// "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId=" + pd_FrpId
		// + "&p0_Cmd=" + p0_Cmd
		// + "&p1_MerId=" + p1_MerId + "&p2_Order=" + p2_Order + "&p3_Amt=" +
		// p3_Amt + "&p4_Cur=" + p4_Cur
		// + "&p5_Pid=" + p5_Pid + "&p6_Pcat=" + p6_Pcat + "&p7_Pdesc=" +
		// p7_Pdesc + "&p8_Url=" + p8_Url
		// + "&p9_SAF=" + p9_SAF + "&pa_MP=" + pa_MP + "&pr_NeedResponse=" +
		// pr_NeedResponse + "&hmac=" + hmac;
		//
		// // 重定向到第三方支付平台
		// response.sendRedirect(url);
		response.getWriter().write("success!");
	}

	// 提交订单
	public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 目的：封装好一个Order对象传递给service层,首先需要判断用户是否已经登陆
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			// 需要加一个return，否则即使跳转下面的语句也会执行
			return;
		}
		Order order = new Order();
		// 封装订单号oid
		String oid = CommonUtils.getUUID();
		order.setOid(oid);
		// 2、private Date ordertime;//下单时间
		order.setOrdertime(new Date());
		// 获得session中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		double total = cart.getTotal();
		order.setState(0);
		order.setAddress("河北省保定市");
		order.setName("董李杰");
		order.setTelephone(null);
		order.setUser(user);
		// 获得购物者车中的购物项的集合map
		Map<String, CartItem> cartItems = cart.getCartItems();
		for (Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
			CartItem cartItem = entry.getValue();
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(CommonUtils.getUUID());
			orderItem.setCount(cartItem.getBuyNum());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);// 订单项所属订单
			// 将订单项添加到订单的订单项集合中
			order.getOrderItems().add(orderItem);

		}
		// Order对象封装完毕
		ProductService service = new ProductService();

		service.submitOrder(order);
		session.setAttribute("order", order);
		// 页面跳转
		response.sendRedirect(request.getContextPath() + "/order_info.jsp");
	}

	// 模块中的功能通过方法进行区分
	// 显示商品的类别的功能
	public void categoryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductService service = new ProductService();
		// 先从redis缓存中查询categoryList,如果有直接使用，没有再从数据库中查询

		// 获取所有类别
		List<Category> categoryList = service.findAllCategory();
		Gson gson = new Gson();
		System.out.println("categoryList is running!");
		String json = gson.toJson(categoryList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	// 商品首页的功能
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ProductService service = new ProductService();
		// 准备热门商品
		System.out.println("index is running!");
		List<Product> hotProductList = service.findHotProductList();
		// 准备最新商品
		List<Product> newProductList = service.findNewProductList();

		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	// 显示商品信息的功能
	public void productInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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

	// 根据商品类别获得商品的列表
	public void getProductByCid(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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

	public void addProducToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 获得放到购物车的商品的pid
		String pid = request.getParameter("pid");
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));

		ProductService service = new ProductService();
		// 获得product对象
		Product product = service.findProductByPid(pid);
		// 计算小计
		// double subtotal = product.getShop_price() * buyNum;
		//
		// CartItem item = new CartItem();
		// item.setProduct(product);
		// item.setBuyNum(buyNum);
		// item.setSubtotal(subtotal);
		// 获得购物车，判断是否在session中已经存在购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		// 将购物项放到车中
		// 先判断该 购物车中是+否已经存在该商品了，如果已经存在将现有的数量和已经数量相加
		Map<String, CartItem> cartItems = cart.getCartItems();
		double newsubtotal;
		if (cartItems.containsKey(pid)) {
			CartItem cartItem = cartItems.get(pid);
			int oldBuyNum = cartItem.getBuyNum();
			oldBuyNum += buyNum;
			cartItem.setBuyNum(oldBuyNum);
			// 修改小计
			double oldsubtotal = cartItem.getSubtotal();// 原先的小计
			// 新的小计
			newsubtotal = buyNum * product.getShop_price();
			cartItem.setSubtotal(newsubtotal + oldsubtotal);

		} else {
			CartItem item = new CartItem();
			item.setProduct(product);
			newsubtotal = buyNum * product.getShop_price();
			item.setBuyNum(buyNum);
			item.setSubtotal(newsubtotal);
			cart.getCartItems().put(product.getPid(), item);

		}
		// 计算总计
		double total = cart.getTotal() + newsubtotal;
		cart.setTotal(total);

		// 将车再次放回到session中去
		session.setAttribute("cart", cart);
		// 直接跳转到购物车页面
		// request.getRequestDispatcher("cart.jsp").forward(request, response);
		// 这里用重定向，是为了防止当跳转到购物车页面，我们如果刷新那个页面，导致购物的数量没变，但购物金额却发生改变
		response.sendRedirect(request.getContextPath() + "/cart.jsp");

	}

	// 删除单一商品
	public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得要删除的pid
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			Map<String, CartItem> cartItems = cart.getCartItems();
			// 删除前需要修改总价
			cart.setTotal(cart.getTotal() - cartItems.get(pid).getSubtotal());
			cartItems.remove(pid);

		}
		session.setAttribute("cart", cart);
		// 跳转回购物车页面
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	// 清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		// 跳转回购物车页面
		response.sendRedirect(request.getContextPath() + "/cart.jsp");

	}
}