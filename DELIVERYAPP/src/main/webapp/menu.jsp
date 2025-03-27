<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverapp.models.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Menu</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body {
            background-color: #ffa500;
        }
        .menu-card {
            transition: transform 0.3s ease-in-out;
            background-color: white;
            color: black;
            width: 300px;
            padding: 20px;
            border-radius: 10px;
        }
        .menu-card:hover {
            transform: scale(1.05);
        }
        .menu-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 10px;
        }
        .add-to-cart {
            transition: background-color 0.3s ease;
            background-color: #ffa500;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .add-to-cart:hover {
            background-color: #ff8c00;
        }
    </style>
</head>
<body>
    <div class="container mx-auto p-6">
        <h1 class="text-3xl font-bold text-white mb-6 text-center">Our Menu</h1>
        
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            <%
            List<Menu> xx = (List<Menu>) request.getAttribute("allrest");
            for(Menu x : xx) {
            %>
            <div class="rounded-xl shadow-lg p-4 menu-card">
                <img src="<%=x.getImagepath()%>" alt="<%=x.getItemname()%>" class="menu-image">
                <h2 class="text-xl font-semibold mt-4"><%=x.getItemname()%></h2>
                <p class="price text-lg font-bold">₹<%=x.getPrice()%></p>
                
                <form action="cart">
                <input type="hidden" name="itemid" value="<%=x.getMenuid() %>">
                <input type="hidden" name="resturantid" value="<%=x.getResturantid() %>">
                <input type="hidden" name="quantity" value="1">
                <input type="hidden" name="action" value="add">
                <button class="add-to-cart">Add to Cart</button>
                </form>
                
                
   
 
            </div>
            <% } %>
        </div>
    </div>
</body>
</html>
