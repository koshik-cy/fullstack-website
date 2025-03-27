<%@page import="java.awt.event.ItemEvent"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.deliverapp.models.Cart" %>
<%@ page import="com.deliverapp.models.CartItem" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 60%;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        .message {
            color: red;
            text-align: center;
            font-weight: bold;
        }
        button {
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            background-color: #28a745;
            color: white;
        }
        button:hover {
            background-color: #218838;
        }
        .btn-remove {
            background-color: #dc3545;
        }
        .btn-remove:hover {
            background-color: #c82333;
        }
        .checkout-buttons {
            text-align: center;
            margin-top: 20px;
        }
        .btn-shop, .btn-checkout {
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 4px;
            color: white;
            margin: 5px;
            display: inline-block;
        }
        .btn-shop {
            background-color: #ffc107;
        }
        .btn-checkout {
            background-color: #007bff;
        }
        .btn-shop:hover {
            background-color: #e0a800;
        }
        .btn-checkout:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your Shopping Cart</h2>

        <!-- Show error message if it exists -->
        <% String msg = request.getParameter("msg");
           if (msg != null) { %>
            <p class="message"><%= msg %></p>
        <% } %>

        <% 
            // Ensure restaurant ID is always present
            Integer restaurantId = (Integer) session.getAttribute("currentresturantid");
            if (restaurantId == null) {
                response.sendRedirect("menu.jsp?msg=Restaurant%20ID%20is%20missing");
                return;
            }

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null || cart.getCartItems().isEmpty()) { 
        %>
            <h3 style="text-align: center; color: gray;">Your cart is empty!</h3>
            <a href="home" class="btn-shop">Continue Shopping</a>
        <% 
            return; 
            } 
        %>

        <table>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
            
            <% 
                double totalPrice = 0;
                for (Map.Entry<Integer, CartItem> entry : cart.getCartItems().entrySet()) {
                    CartItem item = entry.getValue();
                    double itemTotal = item.getPrice() * item.getQuantity();
                    totalPrice += itemTotal;
            %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>
                        <form action="cart" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
                            <input type="hidden" name="resturantid" value="<%= restaurantId %>">
                            <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>">−</button>
                        </form>
                        <strong><%= item.getQuantity() %></strong>
                        <form action="cart" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
                            <input type="hidden" name="resturantid" value="<%= restaurantId %>">
                            <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>">+</button>
                        </form>
                    </td>
                    
                    <td>₹<%= itemTotal %></td>
                    
                    <td>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
                            <input type="hidden" name="resturantid" value="<%= restaurantId %>">
                            <button type="submit" class="btn-remove">Remove</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            
            <tr>
                <td colspan="3" align="right"><strong>Total Price:</strong></td>
                <td><strong>₹<%= totalPrice %></strong></td>
                <td></td>
            </tr>
        </table>

        <div class="checkout-buttons">
        	 <a href="menu?resturantId=<%= session.getAttribute("currentresturantid") %>" class="btn-shop">ADD MORE ITEMS</a>
        	 
        	  <form action="checkout.jsp" method="post">
   				 <button type="submit"> Proceed to Checkout</button>
			</form>  
        </div>
    </div>
</body>
</html>


