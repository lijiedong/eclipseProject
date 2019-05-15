package com.dlj.dynamic;

//动态方法调用
public class Demo1Action {
	public String add() {
		System.out.println("添加用户");
		return "success";
	}

	public String delete() {
		System.out.println("删除用户");
		return "success";
	}

	public String update() {
		System.out.println("修改用户");
		return "success";
	}

	public String query() {
		System.out.println("查询用户");
		return "success";
	}
}
