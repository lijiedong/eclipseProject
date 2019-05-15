package com.dlj.c_param;

import com.dlj.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class Demo9Action extends ActionSupport {
	// 准备一个与参数名一样的变量
	private User user;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user);
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
