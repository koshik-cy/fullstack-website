package com.deliverapp.SerVlets;

import java.io.IOException;
import com.deliverapp.DaoIMPL.menuImplment;
import com.deliverapp.models.Cart;
import com.deliverapp.models.CartItem;
import com.deliverapp.models.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

       
        String restaurantIdParam = req.getParameter("resturantid");
        if (restaurantIdParam == null || restaurantIdParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Restaurant ID is missing");
            return;
        }
        int fid = Integer.parseInt(restaurantIdParam);

        Cart cart = (Cart) session.getAttribute("cart");
        int crid = (session.getAttribute("currentresturantid") != null) ? (int) session.getAttribute("currentresturantid") : -1;

        if (cart == null || crid != fid) {
            cart = new Cart();
            cart.setRestaurantId(fid);
            
            
            session.setAttribute("cart", cart);
            session.setAttribute("currentresturantid", fid);
        }

        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing");
            return;
        }

        switch (action) {
            case "add":
                addItems(req, cart, resp);
                break;
            case "update":
                updateCart(req, cart, resp);
                break;
            case "delete":
                deleteItem(req, cart, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    private void addItems(HttpServletRequest req, Cart c, HttpServletResponse resp) throws IOException {
    
        String itemIdParam = req.getParameter("itemid");
        if (itemIdParam == null || itemIdParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Item ID is missing");
            return;
        }
        int itemid = Integer.parseInt(itemIdParam);

        String quantityParam = req.getParameter("quantity");
        if (quantityParam == null || quantityParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Quantity is missing");
            return;
        }
        int quantity = Integer.parseInt(quantityParam);

        menuImplment mi = new menuImplment();
        Menu m = mi.getMenu(itemid);

        System.out.println("The menu cart servlet is " + m);
        if (m != null) {
            CartItem ci = new CartItem(itemid, m.getItemname(), m.getPrice(), quantity);
            c.addCartItm(ci);
        }

      
        resp.sendRedirect("cart.jsp");
    }

    private void updateCart(HttpServletRequest req, Cart c, HttpServletResponse resp) throws IOException {
        String itemIdParam = req.getParameter("itemid");
        String quantityParam = req.getParameter("quantity");

        if (itemIdParam == null || itemIdParam.isEmpty() || quantityParam == null || quantityParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid update parameters");
            return;
        }

        int itemid = Integer.parseInt(itemIdParam);
        int quantity = Integer.parseInt(quantityParam);

        c.updateCart(itemid, quantity);
        resp.sendRedirect("cart.jsp");
    }

    private void deleteItem(HttpServletRequest req, Cart c, HttpServletResponse resp) throws IOException {
        String itemIdParam = req.getParameter("itemid");

        if (itemIdParam == null || itemIdParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Item ID for deletion is missing");
            return;
        }

        int itemid = Integer.parseInt(itemIdParam);
        c.delete(itemid);
        resp.sendRedirect("cart.jsp");
    }
}

