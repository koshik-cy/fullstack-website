package com.deliverapp.SerVlets;



import java.io.IOException;


import java.io.PrintWriter;

import com.deliverapp.DaoIMPL.userImplmentation;
import com.deliverapp.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/reg")
public class Register extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=(String)req.getParameter("name");
		String email=(String)req.getParameter("email");
		String pass=(String)req.getParameter("password");
		String phone=(String)req.getParameter("phone");
		
		
		
		
	
		User u=new User(name, null, pass, email, phone, null, "Customer", null, null);
		userImplmentation usimp = new userImplmentation();
		
	
		int r = usimp.addUser(u);
		
		PrintWriter out = resp.getWriter();
		
		if(r==1) {
			 out.println("<script type=\"text/javascript\">");
	         out.println("alert('Regestration Successful!');");
	         out.println("window.location = 'login.html';"); 
	         out.println("</script>");
		}
		else {
			 out.println("<script type=\"text/javascript\">");
	         out.println("alert('Registration Falied!');");
		}
		
		
		
		
		
		
		
		
	}
	
	

}
