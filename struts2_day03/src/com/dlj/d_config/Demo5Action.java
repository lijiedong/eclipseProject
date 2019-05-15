package com.dlj.d_config;

import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo2 Action is running!");

		return SUCCESS;
	}

}
