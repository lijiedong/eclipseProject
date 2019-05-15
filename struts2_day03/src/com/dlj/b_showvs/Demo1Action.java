package com.dlj.b_showvs;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1 Action is running!");
		return SUCCESS;
	}

}
