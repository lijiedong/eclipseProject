package com.dlj.a_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dlj.entity.User;

public class Demo {
	@Test
	public void fun1() {
		// 1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.向容器要对象
		User u = (User) ac.getBean("user");
		// 3.打印user对象
		System.out.println(u);
	}
}
