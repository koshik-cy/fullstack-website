package com.deliverapp.DaoIMPL;




import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliverapp.DAO.resturantInterface;
import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.Resturant;

public class resturantImplement implements resturantInterface {
	
	@Override
	public void addResturant(Resturant res) {
		
		// Resturantid, Name, Address, Phone, CusineType,, Adminid, Rating, IsActive, Igamepath
		
		// resturant
		
		
		
		String sql="Insert into `resturant`(Name, Address, Phone, CusineType, "
				+ " Adminid, Rating, IsActive, Igamepath) values (?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql);) {
			
			

			pstm.setString(1, res.getName());
			pstm.setString(2, res.getAddress());
			pstm.setString(3, res.getPhone());
			pstm.setString(4, res.getCusinetype());
			pstm.setInt(5, res.getAdminid());
			pstm.setDouble(6, res.getRating());
			pstm.setString(7, res.getIsactive());
			pstm.setString(8, res.getImagepath());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	@Override
	public Resturant getResturant(int resid) {
		// TODO Auto-generated method stub
		String sql="Select * from `resturant` where `Resturantid`= res;";
		
		// Resturantid, Name, Address, Phone, CusineType, Deliverytime, Adminid, Rating, IsActive, Igamepath
		
		Resturant r=null;
		
		
		try {
			PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql);
			pstm.setInt(1, resid);
			
			ResultSet res=pstm.executeQuery();
			
			int id=res.getInt("Resturantid");
			String name=res.getString("Name");
			String address=res.getString("Address");
			String phone=res.getString("Phone");
			String cusinetype=res.getString("CusineType");
			Date deliverytime=res.getDate("Deliverytime");
			int adminid=res.getInt("Adminid");
			Double rating=res.getDouble("Rating");
			String isactive=res.getString("IsActive");
			String imagepath=res.getString("Igamepath");
			
			
			r=new Resturant(id, name, address, phone, cusinetype, deliverytime, adminid, rating, isactive, imagepath);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
		
	}
	
	
	@Override
	public void updateResturnat(Resturant res) {
		//  Name, Address, Phone, CusineType,Rating, IsActive, Igamepath
		
		String update="Update `resturant` set `Name`=?, `Address`=?,`Phone`=?,`CusineType`=?,`Rating`=?,`IsActive`=?,"
				+ "`Igamepath`=?";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(update);) {	
			
		

			pstm.setString(1, res.getName());
			pstm.setString(2, res.getAddress());
			pstm.setString(3, res.getPhone());
			pstm.setString(4, res.getCusinetype());
			pstm.setDouble(5, res.getRating());
			pstm.setString(6, res.getIsactive());
			pstm.setString(7, res.getImagepath());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Override
	public void deleteResturnat(int resid) {
		// TODO Auto-generated method stub
		String del="Delete from resturant where `Resturantid`=?";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(del)) {
			pstm.setInt(1, resid);
			
			int r=pstm.executeUpdate();
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	

	}
	
	
	
	
	@Override
	public List<Resturant> getallResturant() {
		// TODO Auto-generated method stub
		
		List<Resturant>al=new ArrayList<Resturant>();
		
		Resturant r=null;
		
		// Resturantid, Name, Address, Phone, CusineType,, Adminid, Rating, IsActive, Igamepath
		
		// resturant
		
		String sql="Select * from `resturant`;";
		
		try(Statement stm=DBconnection.getConnection().createStatement();) {
			
			ResultSet res=stm.executeQuery(sql);
			
			while(res.next()) {	
				int id=res.getInt("Resturantid");
				String name=res.getString("Name");
				String address=res.getString("Address");
				String phone=res.getString("Phone");
				String cusinetype=res.getString("CusineType");
				Date deliverytime=res.getDate("Deliverytime");
				int adminid=res.getInt("Adminid");
				Double rating=res.getDouble("Rating");
				String isactive=res.getString("IsActive");
				String imagepath=res.getString("Igamepath");
				
				r=new Resturant(id, name, address, phone, cusinetype, deliverytime, adminid, rating, isactive, imagepath);
				
				al.add(r);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
