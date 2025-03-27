package com.deliverapp.models;

import java.util.Date;

public class User {
	
	
	// Userid, Name, Username, Password, Email,Number, Address, Role, CreateDate, Lastalogin
	
	
	private int userid;
	private String name;
	private String username;
	private String password;
	private String email;
	private String number;
	private String address;
	private String role;
	private Date createdate;
	private Date lastlogin;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String username, String password, String email, String number, String address,
			String role, Date createdate, Date lastlogin) {
		super();
		
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.role = role;
		this.createdate = createdate;
		this.lastlogin = lastlogin;
	}
	



	
	public User(int userid,String name, String username, String password, String email, String number, String address,
			String role, Date createdate, Date lastlogin) {
		super();
		this.userid=userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.role = role;
		this.createdate = createdate;
		this.lastlogin = lastlogin;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	
	
	
	
	
	

}
