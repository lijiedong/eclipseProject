package com.dlj.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	// 指定不拦截登陆方法，其他方法不拦截
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		// 1 获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 2获得登陆标识
		Object object = session.get("user");
		// 3判断登陆标识是否已经存在
		if (object == null) {
			// 不存在就重定向到登陆页面
			return "toLogin";
		} else {
			// 存在就放行
			return invocation.invoke();
		}

	}

}
