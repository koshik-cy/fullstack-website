package com.deliverapp.SerVlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/log")
public class login  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int count=3;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=(String)req.getParameter("email");
		String pa=(String)req.getParameter("password");
		
		String url="jdbc:mysql://localhost:3306/deliveryapp";
		String user="root";
		String pass="root";
		
		
		HttpSession session;
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String query="Select * from `user` where `email`=? and `password`=? ;";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, pa);
			
			ResultSet res = pstm.executeQuery();
			
			
			PrintWriter out = resp.getWriter();
			
			if(res.next()) {
				int r=res.getInt("Userid");
				session=req.getSession();
				session.setAttribute("userId", r);
			
				out.println("<script>alert('Login Successful! Welcome, " + email + "'); window.location='home';</script>");
			}
			else {
				count--;
				 if (count > 0) {
		                out.println("<script>alert('Incorrect email or password. Attempts left: " + count + "'); window.location='login.html';</script>");
		            } else {
		                out.println("<script>alert('Too many failed attempts. Try again later.'); window.location='login.html';</script>");
		            }
			}
			
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
