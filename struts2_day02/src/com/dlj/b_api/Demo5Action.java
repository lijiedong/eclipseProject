package com.dlj.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo5Action is running!");
		ActionContext.getContext().put("name", "requestTom");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "sessionTom");
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationTom");
		return super.execute();
	}

}
