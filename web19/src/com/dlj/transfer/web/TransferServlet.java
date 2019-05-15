package com.dlj.transfer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlj.transfer.service.TransferService;

public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收转账的参数
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		Double money = Double.parseDouble(moneyStr);
		TransferService service = new TransferService();
		boolean flag = service.transfer(out, in, money);
		response.getWriter().write("hello dlj:" + flag);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}