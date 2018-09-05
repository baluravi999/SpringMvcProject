package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.models.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao dao;
	
	@Override
	public int saveUser(User user) {
		return dao.saveUser(user);
	}
	@Override
	public User getUserByNameAndPwd(String un, String pwd) {
		return dao.getUserByNameAndPwd(un, pwd);
	}
}