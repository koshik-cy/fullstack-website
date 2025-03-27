<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Order is Being Prepared</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f8f8f8;
            padding: 50px;
        }
        .message {
            font-size: 24px;
            color: #333;
            font-weight: bold;
        }
        .loader {
            margin: 20px auto;
            border: 5px solid #f3f3f3;
            border-top: 5px solid #fc8019;
            border-radius: 50%;
            width: 50px;
            height: 50px;
            animation: spin 1s linear infinite;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>
<body>

    <div class="message">Your order is getting ready! 🍽️</div>
    <div class="loader"></div>
    <p>Hang tight! We're preparing your delicious meal. 🚀</p>

</body>
</html>
