package com.dlj.c_param;

import com.opensymphony.xwork2.ActionSupport;

public class Demo8Action extends ActionSupport {
	// 准备一个与参数名一样的变量
	private String name;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name + "----");
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
