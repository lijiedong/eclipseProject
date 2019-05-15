package com.dljspringaop;

import org.aspectj.lang.ProceedingJoinPoint;

//通知类
public class MyAdvice {
	// 前置通知，目标方法运行之前调用
	// 后置通知，目标方法运行之后调用（如果出现异常都会调用）
	// 环绕通知，在目标方法之前和之后都调用
	// 异常拦截通知，如果出现异常就会调用
	// 后置通知无论时候出现异常，都会调用（无论是否出现异常都会调用）
	// -----------------------------------------------------------
	// 前置通知
	public void before() {
		System.out.println("这是前置通知！");
	}

	// 后置通知
	public void afterReturning() {
		System.out.println("这是后置通知，如果出现异常就不会调用");
	}

	// 环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知！之前的部分");
		Object proceed = pjp.proceed();// 调用目标方法
		System.out.println("这是环绕通知之后的部分");
		return proceed;
	}

	// 异常通知
	public void afterException() {
		System.out.println("出事啦！出现异常啦！");
	}

	// 后置通知
	public void after() {
		System.out.println("后置通知不出现异常也会调用！");
	}
}
