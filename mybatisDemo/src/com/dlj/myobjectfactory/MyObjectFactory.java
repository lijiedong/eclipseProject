package com.dlj.myobjectfactory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class MyObjectFactory extends DefaultObjectFactory {

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		// TODO Auto-generated method stub
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public <T> T create(Class<T> type) {
		// TODO Auto-generated method stub
		return super.create(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		// TODO Auto-generated method stub
		return super.isCollection(type);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> arg0) {
		// TODO Auto-generated method stub
		return super.resolveInterface(arg0);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
	}

}
