package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER_ACCOUNT3")
public class Login {
@Id
@Column(name="user_name")
private String user_name;
@Column(name="password")
private String password;
@Column(name="gender")
private String gender;
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Login() {
	super();
}
@Override
public String toString() {
	return "Login [user_name=" + user_name + ", password=" + password
			+ ", gender=" + gender + "]";
}
}