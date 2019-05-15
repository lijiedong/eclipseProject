package com.learn.chapter2.main;

import org.apache.ibatis.session.SqlSession;

import com.learn.chapter2.mapper.RoleMapper;
import com.learn.chapter2.po.Role;
import com.learn.chapter2.util.SqlSessionFactoryUtil;

public class Chapter2Main {
	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();

		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		// Role role = roleMapper.getRole(1L);
		// RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = new Role();
		role.setRoleName("zhangsan");
		role.setNote("notes");

		System.out.println(roleMapper.insertRole(role));
		sqlSession.commit();

	}
}
