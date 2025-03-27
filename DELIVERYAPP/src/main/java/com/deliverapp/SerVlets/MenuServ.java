package com.deliverapp.SerVlets;

import java.io.IOException;
import java.util.List;

import com.deliverapp.DaoIMPL.menuImplment;
import com.deliverapp.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServ extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int resid=Integer.parseInt(req.getParameter("resturantId"));
		

		
		menuImplment menimp = new menuImplment();
		
		List<Menu> mlist = menimp.getAllMenu(resid);
		
		req.setAttribute("allrest", mlist);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		
		rd.forward(req, resp);
		
		
		
		
		
		
	}

}
