package com.dlj.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dlj.mapper.RoleMapper;
import com.dlj.pojo.Role;
import com.dlj.utils.SqlSessionFactoryUtil;

public class testInsert {
	@Test
	// 测试删除
	public void testDelete() {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

		System.out.println(roleMapper.delete(10L));
		sqlSession.commit();
		sqlSession.close();
	}

	// 修改元素
	public void testUpdate() {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = new Role();
		role.setRoleName("test10");
		role.setNote("testNote10");
		role.setId(10L);
		System.out.println(roleMapper.upateRole(role));
		sqlSession.commit();
		sqlSession.close();
	}

	// 使用mybatis插入一个元素
	public void test1() {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = new Role();
		role.setRoleName("test4");
		role.setNote("testNote");

		System.out.println(roleMapper.insertRole(role));
		sqlSession.commit();
		sqlSession.close();
	}
}
