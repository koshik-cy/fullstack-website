package com.deliverapp.models;

public class Order {
	
	// orderId, resId, userId, orderDate, totalAmount, status, paymentMode
	
	private int orderid;
	private int resid;
	private int userid;
	private String orderdate;
	private String totalAmount;
	private String status;
	private String paymentmode;
	
	public Order(int orderid, int resid, int userid, String orderdate, String totalAmount, String status,
			String paymentmode) {
		super();
		this.orderid = orderid;
		this.resid = resid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return orderid+", "+resid+", "+userid+", "+orderdate+", "+totalAmount+", "+status+", "+paymentmode;
	}
	
	
	
	
	
	
}
