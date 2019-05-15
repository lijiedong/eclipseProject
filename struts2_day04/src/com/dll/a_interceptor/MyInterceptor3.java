package com.dll.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//创建方法2：继承MethodFilterInterceptor
//方法过滤拦截器
//定制拦截器拦截的方法
public class MyInterceptor3 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		// 前处理
		System.out.println("MyInterceptor3的前处理");
		// 放行
		invocation.invoke();
		// 后处理
		System.out.println("MyInterceptor3的后处理");
		return "success";
	}

}
