package com.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Customer {
@Id
private int cid;
private String name;
private String address;
private int phoneno;

public Customer() {
	super();
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno = phoneno;
}
@Override
public String toString() {
	return "Customer [cid=" + cid + ", name=" + name + ", address=" + address + ", phoneno=" + phoneno + "]";
}


}
