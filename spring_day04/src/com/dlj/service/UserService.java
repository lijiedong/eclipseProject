package com.dlj.service;

import com.dlj.entity.User;

public interface UserService {
	User getUserByCodePassword(User u);

	void saveUser(User u);
}
