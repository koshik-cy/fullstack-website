package com.deliverapp.SerVlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.deliverapp.UTILITY.DBconnection;
import com.deliverapp.models.Cart;
import com.deliverapp.models.CartItem;


@WebServlet("/checkout")
public class checkout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

      
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("login.html");
            return;
        }

      
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getCartItems().isEmpty()) {
            response.sendRedirect("cart.jsp?msg=Cart is empty");
            return;
        }

        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        Connection conn = null;
        PreparedStatement orderStmt = null;
        PreparedStatement orderItemStmt = null;
        ResultSet rs = null;

        try {
            conn = DBconnection.getConnection();
            conn.setAutoCommit(false); 

            String orderSQL = "INSERT INTO `order` (resId, userId, orderDate, totalAmount, status, paymentMode) "
                    + "VALUES (?, ?, NOW(), ?, 'Cooking', ?)";

		    orderStmt = conn.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS);
		    orderStmt.setInt(1, cart.getRestaurantId());  
		    orderStmt.setInt(2, userId); 
		    orderStmt.setDouble(3, cart.getTotalPrice());  
		    orderStmt.setString(4, paymentMethod);  
		    orderStmt.executeUpdate();

        
      


            rs = orderStmt.getGeneratedKeys();

         
            
            
            int orderId = -1; 
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
            System.out.println("Generated Order ID: " + orderId); 

            if (orderId == -1) {
                throw new SQLException("Order ID retrieval failed!");
            }

            // Insert order items into orderitems table
            String orderItemSQL = "INSERT INTO orderitems (orderid, menuid, quantity, totalamount) VALUES (?, ?, ?, ?)";
            orderItemStmt = conn.prepareStatement(orderItemSQL);

            for (CartItem item : cart.getCartItems().values()) {
                orderItemStmt.setInt(1, orderId);  
                orderItemStmt.setInt(2, item.getItemid()); 
                orderItemStmt.setInt(3, item.getQuantity()); 
                orderItemStmt.setDouble(4, item.getPrice() * item.getQuantity());  
                orderItemStmt.addBatch();
            }

            orderItemStmt.executeBatch();  
            System.out.println("Order items inserted successfully.");

            
            conn.commit();

            session.removeAttribute("cart");

            response.sendRedirect("confo.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            response.sendRedirect("checkout.jsp?msg=Error placing order");
        } finally {
            try {
                if (rs != null) rs.close();
                if (orderStmt != null) orderStmt.close();
                if (orderItemStmt != null) orderItemStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


