package com.dlj.c_param;

import com.dlj.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport implements Preparable {
	private User user = new User();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo2 Action is running!");
		System.out.println(user);
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		// 压入栈顶
		// 1.获得值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 2将user压入栈顶
		vs.push(user);
	}

}
