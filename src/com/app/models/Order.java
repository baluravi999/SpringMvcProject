package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TAB3")
public class Order {
	@Id
	@Column(name="oid")
	private int ordId;
	@Column(name="oname")
	private String ordName;
	@Column(name="ocost")
	private float ordCost;
	@Column(name="cId")
	private int custId;
	public Order() {
		super();
	}
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public float getOrdCost() {
		return ordCost;
	}
	public void setOrdCost(float ordCost) {
		this.ordCost = ordCost;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", ordName=" + ordName + ", ordCost="
				+ ordCost + ", custId=" + custId + "]";
	}	
}