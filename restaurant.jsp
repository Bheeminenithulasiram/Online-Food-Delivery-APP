<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.twtfoods.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TWT-Foods - Dashboard</title>
    <link rel="icon" type="image/png" href="https://user-gen-media-assets.s3.amazonaws.com/gpt4o_images/43548a9a-89bb-492e-add7-0ee0e93722f5.png">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <!-- Header -->
    <header>
        <nav class="navbar">
            <div class="logo">
   				 <img src="https://user-gen-media-assets.s3.amazonaws.com/gpt4o_images/43548a9a-89bb-492e-add7-0ee0e93722f5.png" alt="TWT Logo">
    			 <span>TWT-Foods</span>
			</div>

            <ul class="nav-links">

                <li><a href="home">Restaurants</a></li>
                <li><a href="help.html">Help</a></li>
                <li><a href="contact.html">Contact</a></li>
                
            </ul>
        </nav>
    </header>

    <!-- Hero Banner -->
    <section class="hero">
        <div class="hero-content">
            <h1>Delicious Food Delivered Fast</h1>
            <p>Craving something special? We’ve got your taste covered!</p>
            
        </div>
    </section>

    <!-- Featured Restaurants -->
		<section class="featured-restaurants">
        <h2>🌟 Featured Restaurants</h2>
        <div class="restaurant-grid">
            <%
            List<Restaurant> restaurants = (List<Restaurant>)request.getAttribute("allRestaurants");
            for(Restaurant restaurant : restaurants){
            %>
            <a href="menu?restaurantId=<%=restaurant.getRestaurantId() %>" style="text-decoration: none;">
            
            <div class="restaurant-card">
                <img src="<%=restaurant.getImagePath() %>" alt="Restaurant Image">
                <h3><%=restaurant.getName() %></h3>
                <p><%=restaurant.getCuisineType() %> • <%=restaurant.getRating() %> ⭐</p>
                <p class="address"><i class="fas fa-map-marker-alt"></i> <%=restaurant.getAddresss() %></p>
                
                
            </div>	
            
            
            </a>
            <%
            }
            %>
        </div>
    </section>

    <!-- Popular Dishes -->
   
    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>TWT-Foods</h3>
                <p>Your trusted partner in food delivery</p>
            </div>
            <div class="footer-section">
                <h3>Quick Links</h3>
                <ul>
                    <li><a href="home">Home</a></li>
                    <li><a href="help.html">Help</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="index.html">Log out</a></li>
                
                    
                </ul>
            </div>
            <div class="footer-section">
                <h3 id="contact">Contact Us</h3>
                <p>Email: support@twtfoods.com</p>
                <p>Phone: +91 86884 13201</p>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2025 TWT-Foods. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
