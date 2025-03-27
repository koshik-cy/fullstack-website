package com.deliverapp.DAO;

import java.util.List;

import com.deliverapp.models.OrderItmes;

public interface orderItemsInterface {
	void addOrderitem(OrderItmes oi);
	OrderItmes getOrderitem(int orderitmeid);
	void updateOrderitem(OrderItmes oi);
	void deleteOrderitem(int orderitemid);
	
	List<OrderItmes> getAllOrderitems();

}
