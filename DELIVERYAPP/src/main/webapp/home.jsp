<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverapp.models.Resturant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instant Food - Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #1c1c1c;
            color: white;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 50px;
            background-color: #333;
        }

        .navbar .logo {
            font-size: 28px;
            font-weight: bold;
            color: orange;
        }

        .navbar .menu a {
            text-decoration: none;
            color: white;
            margin-left: 20px;
            font-size: 18px;
            transition: 0.3s;
        }

        .navbar .menu a:hover {
            color: orange;
        }

        .hero {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 60vh;
            background: url('https://source.unsplash.com/1600x900/?food') no-repeat center center/cover;
            text-align: center;
            position: relative;
        }

        .hero-overlay {
            position: absolute;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
        }

        .hero-content {
            position: relative;
            z-index: 2;
        }

        .hero h1 {
            font-size: 48px;
            color: white;
        }

        .hero p {
            font-size: 18px;
            margin-top: 10px;
        }

        .search-bar {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .search-bar input {
            width: 300px;
            padding: 10px;
            border: none;
            border-radius: 5px 0 0 5px;
            font-size: 16px;
        }

        .search-bar button {
            padding: 10px 15px;
            background-color: orange;
            border: none;
            border-radius: 0 5px 5px 0;
            color: white;
            cursor: pointer;
            font-size: 16px;
            transition: 0.3s;
        }

        .search-bar button:hover {
            background-color: darkorange;
        }

        .restaurants {
            text-align: center;
            padding: 50px 20px;
        }

        .restaurants h2 {
            font-size: 32px;
            margin-bottom: 20px;
            color: orange;
        }

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            padding: 20px;
            
        }

        .restaurant-card {
            background-color: #333;
            padding: 10px;
            border-radius: 8px;
            transition: 0.3s;
            text-align: center;
        }

        .restaurant-card:hover {
            transform: scale(1.05);
            background-color: #444;
        }

        .restaurant-card img {
            width: 100%;
            height: 120px;
            border-radius: 8px;
            object-fit: cover;
        }

        .restaurant-card h3 {
            margin-top: 8px;
            font-size: 18px;
        }

        .restaurant-card p {
            margin-top: 4px;
            font-size: 14px;
            color: #bbb;
        }
        
        .restaurant-grid a {
   			 text-decoration: none; /* Removes underline from the entire link */
    		color: inherit; /* Ensures text color remains normal */
		}

		.restaurant-card img {
   			 pointer-events: none; /* Prevents image from acting like a clickable link */
		}

        .footer {
            background-color: #222;
            padding: 20px;
            text-align: center;
            font-size: 16px;
            color: white;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="logo">Instant Food</div>
        <div class="menu">
            <a href="#">Home</a>
            <a href="#">Menu</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </div>
    </div>

    <div class="hero">
        <div class="hero-overlay"></div>
        <div class="hero-content">
            <h1>Order Your Favorite Food, Instantly!</h1>
            <p>Delicious meals delivered to your doorstep in minutes.</p>
            <div class="search-bar">
                <input type="text" placeholder="Search for restaurants or dishes...">
                <button>Search</button>
            </div>
        </div>
    </div>

    <div class="restaurants">
        <h2>Top Restaurants</h2>
        <div class="restaurant-grid">
            <%
            List<Resturant> r = (ArrayList<Resturant>) request.getAttribute("ress");
            for (Resturant x : r) {
            %>
            <a href="menu?resturantId=<%=x.getResturantid()%>">
                <div class="restaurant-card">
                    <img src="<%=x.getImagepath()%>" alt="Restaurant Image">
                    <h3><%= x.getName() %></h3>
                    <p>Specialty: <%= x.getCusinetype() %></p>
                    <p>⭐ <%= x.getRating() %></p>
                </div>
            </a>
            <%
            }
            %>
        </div>
    </div>

    <div class="footer">
        &copy; 2025 Instant Food. All rights reserved.
    </div>
</body>
</html>


    