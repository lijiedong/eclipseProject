package com.dlj.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

	public static Object getBean(String id) {
		// TODO Auto-generated method stub
		// 生产对象----根据清单生产----配置文件，将每一个bean对象的生产细节配置到文件中
		// 使用dom4j的xml解析技术
		try {

			// 1.创建解析器
			SAXReader reader = new SAXReader();
			// 2.解析文档----bean.xml在src下
			String path = BeanFactory.class.getClassLoader().getResource("bean.xml").getPath();
			Document doc = reader.read(path);
			// 3.获得元素,参数就是xpath规则
			Element element = (Element) doc.selectSingleNode("//bean[@id='" + id + "']");
			// 获得<bean id="adminService"
			// class="com.dlj.service.impl.AdminServiceImpl"></bean>
			// 中的class属性对应的值
			String className = element.attributeValue("class");
			// 使用反射创建对象
			Class clazz = Class.forName(className);
			Object object = clazz.newInstance();
			return object;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
