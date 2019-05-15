package com.dlj.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1Action is running!");
		return super.execute();
	}

}
