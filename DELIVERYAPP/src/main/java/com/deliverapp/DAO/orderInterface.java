package com.deliverapp.DAO;

import java.util.List;

import com.deliverapp.models.Order;

public interface orderInterface {
	
	void addOrder(Order o);
	Order getOrder(int orderid);
	void updateOrder(Order o);
	void deleteOrder(int orderid);
	List<Order> getAllOrders();
	
}
