package com.deliverapp.DaoIMPL;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliverapp.DAO.userInterface;
import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.User;


public class userImplmentation implements userInterface{
	
	// Userid, Name, Username, Password, Email, Number, Address, Role, CreateDate, Lastalogin
	
	@Override
	public int addUser(User user) {
		
		
		String sql="Insert into user (`Name`,`Username`,`Password`,`Email`,`Number`,`Address`,`Role`)"
				+ "values (?,?,?,?,?,?,?) ;";
		
		int r=0;
		
		try(Connection con= DBconnection.getConnection()) ///try with resources---
		{
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1,user.getName());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getEmail());
			pstm.setString(5, user.getNumber());
			pstm.setString(6, user.getAddress());
			pstm.setString(7, user.getRole());
			
			
			 r=pstm.executeUpdate();
			
			return r;
		

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
		
		
		
		
	}
	
	@Override
	public User getUser(int userid) {
		// TODO Auto-generated method stub
		String sql="Select * from user where `Userid`=? ;";
		
		User user=null;
		
		Connection con=DBconnection.getConnection();
		try(PreparedStatement pstm=con.prepareStatement(sql)) {
			
			// Userid, Name, Username, Password, Email, Number, Address, Role,

			pstm.setInt(1, userid);

			ResultSet res=pstm.executeQuery();
			
			int id=res.getInt("Userid");
			String name=res.getString("Name");
			String username=res.getString("Username");
			String pass=res.getString("Password");
			String email=res.getString("Email");
			String number=res.getString("Number");
			String address=res.getString("Address");
			String role=res.getString("role");

			user=new User(id, name, username, pass, email, number, address, role, null, null);

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
		
	}
		

		
	@Override
	public void updateUser(User user) {
		
		// Name, Password, Number, Address
		
		
		Connection con=DBconnection.getConnection();
		String sql="Update user set `Name`=?, `Password`=?, `Number`=?, `Address`=?  ";
		
		try (PreparedStatement pstm=con.prepareStatement(sql);){
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getNumber());
			pstm.setString(4, user.getAddress());
			
			
			int r=pstm.executeUpdate();
			System.out.println(r);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void deleteUser(int userid) {
		
		Connection con=DBconnection.getConnection();
		
		String sql="Delete from `user` where `userid`=?;";
		
		
		try(PreparedStatement pstm=con.prepareStatement(sql);) {
			pstm.setInt(1, userid);
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@Override
	public List<User> getAllUsers() {
		
		// Userid, Name, Username, Password, Email, Number, Address, Role, CreateDate, Lastalogin
		
		Connection con=DBconnection.getConnection();
		
		String sql="Select * from user";
		
		ArrayList<User> al=new ArrayList<User>();
	

		
		try {
			Statement stm=con.createStatement();
			
			ResultSet res=stm.executeQuery(sql);
			
			User us=null;
			
			while(res.next()) {
				int id=res.getInt("Userid");
				String name=res.getString("Name");
				String username=res.getString("Username");
				String pass=res.getString("Password");
				String email=res.getString("Email");
				String number=res.getString("Number");
				String address=res.getString("Address");
				String role=res.getString("Role");
				Date createdate=res.getDate("CreateDate");
				Date lastlogin=res.getDate("Lastalogin");
				
				 us=new User(id, name, username, pass, email, number, address, role, createdate, lastlogin);
				
				al.add(us);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return al;
	}
	
	
}
	
	
	


		
	
	