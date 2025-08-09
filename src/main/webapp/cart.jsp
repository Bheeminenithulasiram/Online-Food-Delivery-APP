<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.twtfoods.model.Cart, com.twtfoods.model.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TWT- Foods - Cart</title>
    <link rel="icon" type="image/png" href="https://user-gen-media-assets.s3.amazonaws.com/gpt4o_images/43548a9a-89bb-492e-add7-0ee0e93722f5.png">
    <link rel="stylesheet" href="Cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <header>
        <nav>
             <div class="logo">
   				 
    			 <span>TWT-Foods</span>
			</div>
            <ul class="nav-links">
              <li><a href="home">Home</a></li>
                    <li><a href="help.html">Help</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </nav>
    </header>

    <main class="cart-main-layout">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            Integer restaurantId = (Integer) session.getAttribute("restaurantId");
        %>

        <div class="cart-items-wrapper">
            <h1>Your Cart</h1>
            <% if (cart != null && !cart.getItems().isEmpty()) { %>

            <!-- Table Headers -->
            <div class="cart-item cart-header-row">
                <div class="cart-header-name">Name</div>
                <div class="cart-header-quantity">Quantity</div>
                <div class="cart-header-price">Price</div>
            </div>

            <% for (CartItem item : cart.getItems().values()) { %>
            <div class="cart-item">
                <div class="item-info"><%= item.getName() %></div>
                <div class="quantity">
                    <form action="cart">
                        <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                        <input type="hidden" name="resId" value="<%= restaurantId %>">
                        <button class="quantity-btn">+</button>
                    </form>
                    <span><%= item.getQuantity() %></span>
                    <form action="cart">
                        <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                        <input type="hidden" name="resId" value="<%= restaurantId %>">
                        <button class="quantity-btn" <% if (item.getQuantity() == 1) { %>disabled<% } %>>-</button>
                    </form>
                </div>
                <div class="price">₹<%= item.getPrice() %></div>
                <form action="cart">
                    <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="resId" value="<%= restaurantId %>">
                    <button class="remove-btn"><i class="fas fa-trash"></i></button>
                </form>
            </div>
            <% } %>

            <div class="add-more-section">
                <a href="menu?restaurantId=<%= restaurantId %>" class="add-more-btn">
                    <i class="fas fa-plus"></i> Add More Items
                </a>
            </div>

            <% } else { %>
                <p>Your cart is empty.</p>
                <div class="add-more-section">
                    <a href="menu?restaurantId=<%= restaurantId %>" class="add-more-btn">
                        <i class="fas fa-plus"></i> Start Ordering
                    </a>
                </div>
            <% } %>
        </div>

        <% if (cart != null && !cart.getItems().isEmpty()) { %>
        <div class="cart-summary">
            <h2>Order Summary</h2>
            <div class="summary-total">
                <span>Total</span>
                <span>₹<%= cart.getTotalPrice() %></span>
            </div>
            <form action="Checkout.jsp" method="post">
                <button class="checkout-btn">Proceed to Checkout</button>
            </form>
        </div>
        <% } %>
    </main>

    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>TWT-Foods</h3>
                <p>Delivering happiness to your doorstep.</p>
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
                <h3>Contact</h3>
                <p>Email: support@foodexpress.com</p>
                <p>Phone: +91 98765 43210</p>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 FoodExpress. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
