package com.dlj.dao;

import com.dlj.entity.User;

public interface UserDao {
	User getByUserCode(String username);

	void saveUser(User u);
}
