package com.dlj.c_param;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Demo11Action extends ActionSupport {
	// 准备一个与参数名一样的变量
	private List<String> list;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		return "success";
	}

}
