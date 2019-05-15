package com.dlj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dlj.mapper.RoleMapper;
import com.dlj.pojo.Role;

import params.RoleParam;

public class MyBatisUtil {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			// 创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			// System.out.println(sqlSessionFactory.getConfiguration().getDatabaseId()
			// + "--");
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Map<String, String> paramsMap = new HashMap<>();
			paramsMap.put("roleName", "zhangsan");
			paramsMap.put("note", "notes");
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			RoleParam params = new RoleParam();
			params.setNote("notes");
			params.setRoleName("zhangsan");
			List<Role> lists = roleMapper.findRoleByMap1(params);
			for (int i = 0; i < lists.size(); i++) {
				System.out.println(lists.get(i));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
