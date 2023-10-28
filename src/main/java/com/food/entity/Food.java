package com.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Food {
	@Id
	private int fid;
	private String fname;
	private int amt;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", amt=" + amt + "]";
	}

}
