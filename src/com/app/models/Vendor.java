package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="VEN_TAB3")
public class Vendor implements Comparable<Vendor>{

	@Id
	
	@Column(name="vid")
	private int venId;
	@Column(name="vcode")
	private String venCode;
	@Column(name="vname")
	private String venName;
	@Column(name="vtype")
	private String venType;
	@Column(name="vemail")
	private String venEmail;
	@Column(name="vcontact")
	private String venContact;
	@Column(name="vaddr")
	private String venAddr;
	public Vendor() {
		super();
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getVenEmail() {
		return venEmail;
	}
	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	public String getVenContact() {
		return venContact;
	}
	public void setVenContact(String venContact) {
		this.venContact = venContact;
	}
	public String getVenAddr() {
		return venAddr;
	}
	public void setVenAddr(String venAddr) {
		this.venAddr = venAddr;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName="
				+ venName + ", venType=" + venType + ", venEmail=" + venEmail
				+ ", venContact=" + venContact + ", venAddr=" + venAddr + "]";
	}
	public int compareTo(Vendor o)
	{
		return this.getVenId()- o.getVenId();
	}
}