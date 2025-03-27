package com.deliverapp.UTILITY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	public static  Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/DeliveryApp";
		String user="root";
		String password="root";
		Connection connection=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return connection;
		
		
	}
	

}
