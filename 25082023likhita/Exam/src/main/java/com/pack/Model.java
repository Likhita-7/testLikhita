package com.pack;

import java.util.Date;

public class Model {
	int id;
	String name;
	String category;
	Double price;
	Date date;
	int stock_qnt;
	String isavl;
	public Model(int id, String name, String category, Double price, Date date, int stock_qnt, String isavl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.date = date;
		this.stock_qnt = stock_qnt;
		this.isavl = isavl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStock_qnt() {
		return stock_qnt;
	}
	public void setStock_qnt(int stock_qnt) {
		this.stock_qnt = stock_qnt;
	}
	public String getIsavl() {
		return isavl;
	}
	public void setIsavl(String isavl) {
		this.isavl = isavl;
	}
	
	
	

}
