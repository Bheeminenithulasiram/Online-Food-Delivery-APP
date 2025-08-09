package com.twtfoods.servlets;

import java.io.IOException;

import com.twt_foods.daoimpl.MenuDAOImp;
import com.twtfoods.model.Cart;
import com.twtfoods.model.CartItem;
import com.twtfoods.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		Integer sessRestaurantId = (Integer)session.getAttribute("restaurantId");	
		int newRestaurantId = Integer.parseInt(req.getParameter("resId"));
	
		
		if(cart == null || sessRestaurantId == null || sessRestaurantId.intValue() != newRestaurantId ) {			
			cart = new Cart();			
			session.setAttribute("cart", cart);			
		session.setAttribute("restaurantId", newRestaurantId);
	}
		
		
	
		String action = req.getParameter("action");
	
	if(action.equalsIgnoreCase("add")) {
		
			addItemToCart(req,cart);
		} else if(action.equalsIgnoreCase("update")) {
			
			updateItemToCart(req,cart);
			
		}else if(action.equalsIgnoreCase("delete")) {
			
		deleteItemToCart(req,cart);
		
	}else if(action.equalsIgnoreCase("Total")) {
		
		
	}
	
	resp.sendRedirect("cart.jsp");
	
		
	}

	private void deleteItemToCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("menuId"));
		cart.removeItem(itemId);
		
		
		
		
		
		
		


		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
		
		
		
		
		
		
		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
	
		int menuId = Integer.parseInt(req.getParameter("menuId"));
	
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImp menuDAOImp = new MenuDAOImp();
		
		Menu menu = menuDAOImp.getMenu(menuId);
		
	
	
		CartItem cartItem = new CartItem(menuId, menu.getRestaurantId(), menu.getItemName(), quantity, menu.getPrice());
		
		
		cart.addItem(cartItem);

	}

}
