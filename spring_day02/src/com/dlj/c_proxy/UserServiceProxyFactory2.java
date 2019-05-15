package com.dlj.c_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.dlj.service.UserService;
import com.dlj.service.UserServiceImpl;

public class UserServiceProxyFactory2 implements MethodInterceptor {
	private UserService us;

	public UserService getUserServiceProxy() {
		// 生成动态代理
		Enhancer en = new Enhancer();// 帮我们生成代理对象
		en.setSuperclass(UserServiceImpl.class);// 设置对谁进行代理
		en.setCallback(this);// 代理要做什么
		return (UserService) en.create();// 创建代理对象
	}

	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		// 打开事务
		System.out.println("打开事务");
		// 调用原有方法
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);
		// 提交事务
		System.out.println("提交事务");
		return null;
	}

}
