package com.deliverapp.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliverapp.DAO.orderInterface;
import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.Order;

public class orderImplment implements orderInterface {
	
	@Override
	public void addOrder(Order o) {
		// orderId, resId, userId, orderDate, totalAmount, status, paymentMode
		// try with resource;
		
		String sql="Insert into `order` (`orderId`,`resId`,`userId`,`orderDate`,`totalAmount`,`status`,`paymentMode`)"
				+ " values (?,?,?,?,?,?,?)";
		
		try(PreparedStatement pstm= DBconnection.getConnection().prepareCall(sql)) {
			pstm.setInt(1, o.getOrderid());
			pstm.setInt(2, o.getResid());
			pstm.setInt(3, o.getUserid());
			pstm.setString(4, o.getOrderdate());
			pstm.setString(5, o.getTotalAmount());
			pstm.setString(6, o.getStatus());
			pstm.setString(7, o.getPaymentmode());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public Order getOrder(int orderid) {
		String sql="Select * from `order` where `orderId`=? ;";
		
		Order o=null;
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)){
			pstm.setInt(1, orderid);
			
			ResultSet res=pstm.executeQuery();
			
			while(res.next()) {
				
				o=new Order(res.getInt("orderId"),res.getInt("resId"),res.getInt("userId"),res.getString("orderDate"),
						res.getString("totalAmount"), res.getString("status"), res.getString("paymentMode"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return o;
		
	
	}
	
	@Override
	public void updateOrder(Order o) {
		// TODO Auto-generated method stub
		String sql="Update `order` set `status`=? ;";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)) {
			pstm.setString(1, o.getStatus());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		String del="Select * from `order` where `orderId`=?; ";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(del)){
			pstm.setInt(1, orderid);
			
			int r = pstm.executeUpdate();
			
			System.out.println(r);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		List<Order> al=new ArrayList<Order>();
		
		String sql="Select * from `order` ;";
		try(Statement stm=DBconnection.getConnection().createStatement()) {
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				al.add(new Order(res.getInt("orderId"),res.getInt("resId"),res.getInt("userId"),res.getString("orderDate"),
						res.getString("totalAmount"), res.getString("status"), res.getString("paymentMode")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return al;
	}

}
