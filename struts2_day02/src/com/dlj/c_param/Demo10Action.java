package com.dlj.c_param;

import com.dlj.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo10Action extends ActionSupport implements ModelDriven<User> {
	// 准备一个与参数名一样的变量
	private User user = new User();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user);
		return "success";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
