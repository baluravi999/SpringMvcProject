package com.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dao.ILoginDao;
import com.app.models.Login;
import com.app.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

private ILoginDao dao;
	@Override
	public String saveUser(Login login) {
		return dao.saveUser(login);
	}

	@Override
	public void updateUser(Login login) {
		dao.updateUser(login);
	}

	@Override
	public void deleteUser(String user_name) {
	    dao.deleteUser(user_name);
	}

	@Override
	public Login getUserByName(String user_name) {
		return dao.getUserByName(user_name);
	}

	@Override
	public List<Login> getAllUsers() {
		return dao.getAllUsers();
	}
}