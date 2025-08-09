package com.twtfoods.servlets;

import java.io.IOException;
import java.util.List;

import com.twt_foods.daoimpl.RestaurantDAOImp;
import com.twtfoods.DAO.RestaurantDAO;
import com.twtfoods.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	RestaurantDAO restaurantDAOImp = new RestaurantDAOImp();		
	
	List<Restaurant> allRestaurants = restaurantDAOImp.getAllRestaurants();
	
	for (Restaurant restaurant : allRestaurants) {
		
		System.out.println(restaurant);
		
	}
	
	req.setAttribute("allRestaurants", allRestaurants);
	
	RequestDispatcher requestDispatcher = req.getRequestDispatcher("restaurant.jsp");
	requestDispatcher.forward(req, resp);
	
	
	
	
	
	}

}
