package com.twtfoods.servlets;

import java.io.IOException;
import java.util.List;

import com.twt_foods.daoimpl.MenuDAOImp;
import com.twtfoods.DAO.MenuDAO;
import com.twtfoods.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
				
		MenuDAO menuDAOImp = new MenuDAOImp();
		
		List<Menu> allMenuByRestaurantId = menuDAOImp.getAllMenuByRestaurantId(restaurantId);
		
		for (Menu menu : allMenuByRestaurantId) {
			
					System.out.println(menu);
			
		}
		
		req.setAttribute("allMenuByRestaurantId", allMenuByRestaurantId);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
	}

}
