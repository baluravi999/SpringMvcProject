package com.app.dao;

import com.app.models.User;

public interface IUserDao {
	
	public int saveUser(User user);
	public User getUserByNameAndPwd(String un,String pwd);
}