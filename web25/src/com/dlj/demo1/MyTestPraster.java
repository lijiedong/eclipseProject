package com.dlj.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestPraster {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
		// 获得TestDemo字节码对象
		Class c = TestDemo.class;
		// 获得所有的方法
		Method[] methods = c.getMethods();
		if (methods != null) {
			for (Method method : methods) {
				// 判断方法是否使用了@MyTest注解
				boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
				if (annotationPresent) {
					method.invoke(c.newInstance());
				}
			}
		}
	}

}
