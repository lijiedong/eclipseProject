package com.dlj.b_tag;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("ad");
		list.add("sb");
		list.add("agh");
		ActionContext.getContext().put("list", list);
		return "success";
	}

}
