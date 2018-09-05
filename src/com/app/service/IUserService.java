package com.app.service;

import com.app.models.User;

public interface IUserService {

	public int saveUser(User user);
	public User getUserByNameAndPwd(String un, String pwd);
}
