package com.dll.a_interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1Action_add");
		return SUCCESS;
	}

	public String delete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1Action_delete");
		return SUCCESS;
	}

	public String update() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1Action_update");
		return SUCCESS;
	}

	public String find() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo1Action_find");
		return SUCCESS;
	}

}
