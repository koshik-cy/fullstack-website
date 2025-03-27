package com.deliverapp.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliverapp.DAO.orderItemsInterface;
import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.OrderItmes;

public class orderItemsImple implements orderItemsInterface{
	
	// orderitemId, orderid, menuid, quantity, totalamount   // orderitems
	
	@Override
	public void addOrderitem(OrderItmes oi) {
		
		String sql="Insert into `orderitems`(orderitemId, orderid, menuid, quantity, totalamount) values (?,?,?,?,?)";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)) {
			pstm.setInt(1, oi.getOrderitemid());
			pstm.setInt(2, oi.getOrderid());
			pstm.setInt(3, oi.getMenuid());
			pstm.setInt(4, oi.getQuantity());
			pstm.setInt(5, oi.getTotalamount());
			
			int r=pstm.executeUpdate();
			System.out.println(r);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public OrderItmes getOrderitem(int orderitmeid) {
		// TODO Auto-generated method stub
		OrderItmes oi=null;
		String sql="Select * from `orderitems` where `orderitemId`=?; ";
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)){
			pstm.setInt(1, orderitmeid);
			
			ResultSet res=pstm.executeQuery();
			
			while(res.next()) {
				oi=new OrderItmes(res.getInt("orderitemId"),res.getInt("orderid"), res.getInt("menuid"), 
						res.getInt("quantity"), res.getInt("totalamount"));
			}
			

			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return oi;
	}
	
	@Override
	public void updateOrderitem(OrderItmes oi) {
		// TODO Auto-generated method stub
		String sql="Update `orderitems` set `orderitemId`=?, `orderid`=?, `menuid`=?, `quantity`=?, `totalamount`=? ;";
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)){
			pstm.setInt(1, oi.getOrderitemid());
			pstm.setInt(2, oi.getOrderid());
			pstm.setInt(3, oi.getMenuid());
			pstm.setInt(4, oi.getQuantity());
			pstm.setInt(5, oi.getTotalamount());
			
			int r=pstm.executeUpdate();
			System.out.println(r);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void deleteOrderitem(int orderitemid) {
		// TODO Auto-generated method stub
		String del="Delete from `orderitems` where `orderitemId`=? ;";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(del)) {
			pstm.setInt(1, orderitemid);
			
			int r=pstm.executeUpdate();
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<OrderItmes> getAllOrderitems() {
		ArrayList<OrderItmes>al=new ArrayList<OrderItmes>();
		String sql="Select * from `orderitems`;";
		try(Statement stm=DBconnection.getConnection().createStatement()) {
			ResultSet res=stm.executeQuery(sql);
			
			while(res.next()) {
				al.add(new OrderItmes(res.getInt("orderitemId"),res.getInt("orderid"), res.getInt("menuid"), 
						res.getInt("quantity"), res.getInt("totalamount")));
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return al;
	}

}
