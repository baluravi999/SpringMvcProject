package com.app.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.ILoginDao;
import com.app.models.Login;

@Repository
public class LoginDaoImpl implements ILoginDao {
	
@Autowired
private HibernateTemplate ht;
	@Override
	public String saveUser(Login login) {
		String user_name =(String)ht.save(login);
		return user_name;
	}

	@Override
	public void updateUser(Login login) {
		ht.update(login);
	}

	@Override
	public void deleteUser(String user_name) {
		Login login=new Login();
		login.setUser_name(user_name);
        ht.delete(login);
	}

	@Override
	public Login getUserByName(String user_name) {
	    Login login =(Login)ht.get(Login.class,user_name);
		return null;
	}

	@Override
	public List<Login> getAllUsers() {
		List<Login> userList=ht.loadAll(Login.class);
		return userList;
	}
}