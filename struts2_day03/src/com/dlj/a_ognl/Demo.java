package com.dlj.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dlj.entity.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo {
	@Test
	// 基本语法
	// 创建对象
	public void fun7() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user2", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 给roo中的name属性赋值
		Integer size = (Integer) Ognl.getValue("{'dlj','ypf','zl'}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("{'dlj','ypf','zl'}.get(0)", oc, oc.getRoot());
		Integer size1 = (Integer) Ognl.getValue("#{'name':'dlj','age':18}.size()", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("#{'name':'dlj','age':18}['name']", oc, oc.getRoot());

		System.out.println(size1 + name2);
	}

	// 基本语法
	// 调用静态方法
	public void fun6() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user2", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 给roo中的name属性赋值
		Ognl.getValue("setName('dlj')", oc, oc.getRoot());

		String value1 = (String) Ognl.getValue("@com.dlj.utils.testUtils@echo('hello')", oc.getRoot());
		String value2 = (String) Ognl.getValue("#user1.setName('dljs'),#user1.getName()", oc, oc.getRoot());

		System.out.println(value1);
	}

	// 基本语法
	// 调用方法
	public void fun5() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user2", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 给roo中的name属性赋值
		Ognl.getValue("setName('dlj')", oc, oc.getRoot());

		String value1 = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		String value2 = (String) Ognl.getValue("#user1.setName('dljs'),#user1.getName()", oc, oc.getRoot());

		System.out.println(value2);
	}

	// 基本语法
	// 给属性赋值
	public void fun4() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user2", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 给roo中的name属性赋值
		String value = (String) Ognl.getValue("name='jerry'", oc, oc.getRoot());
		String value1 = (String) Ognl.getValue("name", oc, oc.getRoot());

		System.out.println(value + "---" + value1);
	}

	// 基本语法
	// 取出context中的属性值
	public void fun3() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user2", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 去除context中user1对象的name属性
		// #代表从context中取值
		String value = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());

		System.out.println(value);
	}

	// 基本语法
	// 取出root中的属性值
	public void fun2() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user1", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		// 取出root中user对象的name属性
		String value = (String) Ognl.getValue("name", oc, oc.getRoot());
		System.out.println(value);
	}

	// 准备工作
	public void fun1() throws OgnlException {
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("tom", 18);
		// 准备Context
		Map<String, User> context = new HashMap<String, User>();
		context.put("user1", new User("Jack", 18));
		context.put("user1", new User("Rose", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL
		Ognl.getValue("", oc, oc.getRoot());
	}
}
