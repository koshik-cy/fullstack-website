package com.deliverapp.models;

public class Menu {
	
	// Menuid, Resturantid, Itemname, Description, Price, IsAvaliable, Ratings, Imagepath
	
	private int menuid;
	private int resturantid;
	private String itemname;
	private String description;
	private double price;
	private String isavaliable;
	private double ratings;
	private String imagepath;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Menu(int menuid, int resturantid, String itemname, String description, double price, String isavaliable,
			double ratings, String imagepath) {
		super();
		this.menuid = menuid;
		this.resturantid = resturantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavaliable = isavaliable;
		this.ratings = ratings;
		this.imagepath = imagepath;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsavaliable() {
		return isavaliable;
	}

	public void setIsavaliable(String isavaliable) {
		this.isavaliable = isavaliable;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return resturantid+","+menuid+","+itemname+","+description+","+price+","+isavaliable+","+ratings+","+imagepath;
	}
	
	
	
	
	
	
}
