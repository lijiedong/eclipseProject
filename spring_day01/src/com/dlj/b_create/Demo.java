package com.dlj.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dlj.entity.User;

public class Demo {
	@Test
	// 创建方式三：实例工厂创建
	public void fun3() {
		// 1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/dlj/b_create/applicationContext.xml");
		// 2.向容器要对象
		User u = (User) ac.getBean("user3");
		// 3.打印user对象
		System.out.println(u);
	}

	// 创建方式二：静态工厂创建
	public void fun2() {
		// 1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/dlj/b_create/applicationContext.xml");
		// 2.向容器要对象
		User u = (User) ac.getBean("user2");
		// 3.打印user对象
		System.out.println(u);
	}

	// 创建方式一：空参构造创建
	public void fun1() {
		// 1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/dlj/b_create/applicationContext.xml");
		// 2.向容器要对象
		User u = (User) ac.getBean("user3");
		// 3.打印user对象
		System.out.println(u);
	}
}
