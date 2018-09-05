package com.app.service;

import java.util.List;
import com.app.models.Login;

public interface ILoginService {

	public String saveUser(Login login);
	public void updateUser(Login login);
	public void deleteUser(String user_name);
	public Login getUserByName(String user_name);
	public List<Login> getAllUsers();
}