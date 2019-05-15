package com.dlj.a_jdbctemplate;

import java.util.List;

import com.dlj.entity.User;

public interface UserDao {
	// 增
	void save(User u);

	// 删除
	void delete(Integer id);

	// 改
	void update(User u);

	// 查
	User getById(Integer id);

	// 查总的行数
	int getTotalCount();

	// 查所有的用户
	List<User> getAll();
}
