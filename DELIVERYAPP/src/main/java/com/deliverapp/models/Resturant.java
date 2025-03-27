package com.deliverapp.models;




import java.sql.Date;



public class Resturant {
	
	// Resturantid, Name, Address, Phone, CusineType, Adminid, Rating, IsActive, Igamepath
	
	private int resturantid;
	private String name;
	private String address;
	private String phone;
	private String cusinetype;
	private Date deliverytime;
	private int adminid;
	private double rating;
	private String isactive;
	private String  imagepath;
	
	public Resturant(int resturantid, String name, String address, String phone, String cusinetype,Date deliverytime, int adminid,
			double rating, String isactive, String imagepath) {
		super();
		this.resturantid = resturantid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cusinetype = cusinetype;
		this.deliverytime=deliverytime;
		this.adminid = adminid;
		this.rating = rating;
		this.isactive = isactive;
		this.imagepath = imagepath;
	}
	
	public Resturant() {
		// TODO Auto-generated constructor stub
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCusinetype() {
		return cusinetype;
	}

	public void setCusinetype(String cusinetype) {
		this.cusinetype = cusinetype;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath =imagepath;
	}

	public Date getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}
	
	
	
	
	
	
	
	

}
