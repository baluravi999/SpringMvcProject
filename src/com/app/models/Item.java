package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TAB3")
public class Item {
@Id
@Column(name="iId")
private int itemId;
@Column(name="iName")
private String itemName;
@Column(name="iCost")
private Double baseCost;
/*@Column(name="iCode")
private String itemCode;
@Column(name="iBCode")
private String barCode;
@Column(name="iDiscount")
private double maxDiscount;
@Column(name="iMfg")
private String mfg;*/
@Column(name="cId")
private int custId;
public Item() {
	super();
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public Double getBaseCost() {
	return baseCost;
}
public void setBaseCost(Double baseCost) {
	this.baseCost = baseCost;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
@Override
public String toString() {
	return "Item [itemId=" + itemId + ", itemName=" + itemName + ", baseCost="
			+ baseCost + ", custId=" + custId + "]";
}

}