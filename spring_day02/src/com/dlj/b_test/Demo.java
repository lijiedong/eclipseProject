package com.dlj.b_test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlj.entity.User;

//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
// 指定创建容器时，使用哪个配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	// 将名为user的对象注入到u变量中
	@Resource(name = "user")
	private User u;

	@Test
	public void fun1() {

		System.out.println(u);
	}
}
