package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUST_TAB3")
public class Customer {

@Id
@Column(name="cid")
private int custId;
@Column(name="ccode")
private String custCode;
@Column(name="cname")
private String custName;
@Column(name="cctrtime")
private double contrtime;
@Column(name="cperc")
private double percent;
@Column(name="cmode")
private String custMode;
@Column(name="cemail")
private String custEmail;
@Column(name="ctype")
private String custType;
@Column(name="caddr")
private String custAddr;
@Column(name="cdesc")
private String custDesc;
@Column(name="cpwd")
private String Password;
@Column(name="cacctoken")
private String AccToken;
public Customer() {
	super();
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustCode() {
	return custCode;
}
public void setCustCode(String custCode) {
	this.custCode = custCode;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public double getContrtime() {
	return contrtime;
}
public void setContrtime(double contrtime) {
	this.contrtime = contrtime;
}
public double getPercent() {
	return percent;
}
public void setPercent(double percent) {
	this.percent = percent;
}
public String getCustMode() {
	return custMode;
}
public void setCustMode(String custMode) {
	this.custMode = custMode;
}
public String getCustEmail() {
	return custEmail;
}
public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}
public String getCustType() {
	return custType;
}
public void setCustType(String custType) {
	this.custType = custType;
}
public String getCustAddr() {
	return custAddr;
}
public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
}
public String getCustDesc() {
	return custDesc;
}
public void setCustDesc(String custDesc) {
	this.custDesc = custDesc;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getAccToken() {
	return AccToken;
}
public void setAccToken(String accToken) {
	AccToken = accToken;
}
@Override
public String toString() {
	return "Customer [custId=" + custId + ", custCode=" + custCode
			+ ", custName=" + custName + ", contrtime=" + contrtime
			+ ", percent=" + percent + ", custMode=" + custMode
			+ ", custEmail=" + custEmail + ", custType=" + custType
			+ ", custAddr=" + custAddr + ", custDesc=" + custDesc
			+ ", Password=" + Password + ", AccToken=" + AccToken + "]";
}

}