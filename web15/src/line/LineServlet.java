package line;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得请求方式
		String method = request.getMethod();
		// 2.获得与请求的资源相关的内容
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("method:" + method);
		System.out.println("uri:" + requestURI);
		System.out.println("url:" + requestURL);
		System.out.println("web应用名称：" + request.getContextPath());
		System.out.println("querystring:" + request.getQueryString());
		response.getWriter().write("hello dlj");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}