package com.deliverapp.DaoIMPL;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.deliverapp.DAO.menuInterface;
import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.Menu;


public class menuImplment implements menuInterface {
	
	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		String sql="Insert into `menu` (`Resturantid`, `Itemname`, `Description`, "
				+ "`Price`, `IsAvaliable`, `Ratings`, `Imagepath`) values (?,?,?,?,?,?,?)";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)) {
			pstm.setInt(1, menu.getResturantid());
			pstm.setString(2, menu.getItemname());
			pstm.setString(3, menu.getDescription());
			pstm.setDouble(4, menu.getPrice());
			pstm.setString(5, menu.getIsavaliable());
			pstm.setDouble(6, menu.getRatings());
			pstm.setString(7, menu.getImagepath());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Menu getMenu(int menuid) {
		// Menuid, Resturantid, Itemname, Description, Price, IsAvaliable, Ratings, Imagepath
		
		String sql="Select * from `menu` where `Menuid`=?;";
		
		Menu menu=null;
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)) {
			pstm.setInt(1, menuid);
			
			
			ResultSet res=pstm.executeQuery();
			
			while(res.next()) {
				int menuuid=res.getInt("Menuid");
				int resturantid=res.getInt("Resturantid");
				String itemname=res.getString("Itemname");
				String descp=res.getString("Description");
				double price=res.getDouble("Price");
				String isavaliable=res.getString("IsAvaliable");
				double ratings=res.getDouble("Ratings");
				String imagepath=res.getString("Imagepath");
			
			
			menu=new Menu(menuuid, resturantid, itemname, descp, price, isavaliable, ratings, imagepath);
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return menu;
	}
	
	
	
	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		String sql="Update `menu` set `Resturantid`=?,`Itemname`=?, `Description`=?,"
				+ " `Price`=?, `IsAvaliable`=?, `Ratings`=?, `Imagepath`=?";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)){
			pstm.setInt(1, menu.getResturantid());
			pstm.setString(2, menu.getItemname());
			pstm.setString(3, menu.getDescription());
			pstm.setDouble(4, menu.getPrice());
			pstm.setString(5, menu.getIsavaliable());
			pstm.setDouble(6, menu.getRatings());
			pstm.setString(7, menu.getImagepath());
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteMenu(int menuid) {
		// TODO Auto-generated method stub
		String delete="Delete from `menu` where `menuid`=?";
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(delete)) {
			pstm.setInt(1, menuid);
			
			int r=pstm.executeUpdate();
			
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@Override
	public List<Menu> getAllMenu(int resid) {
		
		ArrayList<Menu>al=new ArrayList<Menu>();
		
		String sql="Select * from `menu` where `Resturantid`=?;";
		
		Menu m=null;
		
		try(PreparedStatement pstm=DBconnection.getConnection().prepareStatement(sql)) {
			pstm.setInt(1, resid);
			
			ResultSet res = pstm.executeQuery();
			
			while(res.next()) {
				
				
				int menuuid=res.getInt("Menuid");
				int resturantid=res.getInt("Resturantid");
				String itemname=res.getString("Itemname");
				String descp=res.getString("Description");
				double price = res.getDouble("Price");
				String isavaliable=res.getString("IsAvaliable");
				double ratings=res.getDouble("Ratings");
				String imagepath=res.getString("Imagepath");
				
				m=new Menu(menuuid, resturantid, itemname, descp, price, isavaliable, ratings, imagepath);
				
				al.add(m);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		return al;
	}
	
	
	
	
}
