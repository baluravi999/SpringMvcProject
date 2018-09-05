package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="LOC_TAB3")
public class Location implements Comparable<Location>{
	@Id
	@Column (name="lid")
	private int locId;
	@Column(name="lcode")
	private String locCode;
	@Column (name="lname")
	private String locName;
	@Column (name="ltype")
	private String locType;
	
	public int getLocId() {
		return locId;
	}
	@Required
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocCode() {
		return locCode;
	}
	@Required
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getLocName() {
		return locName;
	}
	@Required
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocType() {
		return locType;
	}
	@Required
	public void setLocType(String locType) {
		this.locType = locType;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locCode=" + locCode + ", locName=" + locName + ", locType=" + locType + "]";
	}
	public Location() {
		super();
	}
	public Location(int locId) {
		super();
		this.locId = locId;
	}

	public int compareTo(Location o)
	{
		return this.getLocId()- o.getLocId();
	}
}