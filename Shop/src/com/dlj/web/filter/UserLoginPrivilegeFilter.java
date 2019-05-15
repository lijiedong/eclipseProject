package com.dlj.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlj.domain.User;

/**
 * Servlet Filter implementation class UserLoginPrivilegeFilter
 */
public class UserLoginPrivilegeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserLoginPrivilegeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(req.getContextPath() + "/login.jsp");
			// 需要加一个return，否则即使跳转下面的语句也会执行
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
