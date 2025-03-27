package com.deliverapp.SerVlets;

import java.io.IOException;
import java.util.List;

import com.deliverapp.DaoIMPL.resturantImplement;
import com.deliverapp.models.Resturant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resturantImplement resimpl = new resturantImplement();
		
		List<Resturant> list= resimpl.getallResturant();
		
		
		req.setAttribute("ress", list);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
	
	

}
