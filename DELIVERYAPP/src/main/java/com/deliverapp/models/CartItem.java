package com.deliverapp.models;

public class CartItem {
	
	private int itemid;
	private String name;
	private double price;
	private int quantity;
	
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}


	public CartItem(int itemid, String name, double price, int quantity) {
		super();
		this.itemid = itemid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


	public int getItemid() {
		return itemid;
	}


	public void setItemid(int itemid) {
		this.itemid = itemid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "CARTmodel [itemid=" + itemid + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
