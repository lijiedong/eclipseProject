package com.dlj.web.action;

import com.dlj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(userService.toString());
		return "success";
	}

}
