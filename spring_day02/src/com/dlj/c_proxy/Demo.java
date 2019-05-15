package com.dlj.c_proxy;

import org.junit.Test;

import com.dlj.service.UserService;
import com.dlj.service.UserServiceImpl;

public class Demo {
	@Test
	public void fun2() {
		UserService us = new UserServiceImpl();
		// UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.update();
	}

	public void fun1() {
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.update();
	}
}
