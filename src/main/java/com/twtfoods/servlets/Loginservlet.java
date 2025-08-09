package com.twtfoods.servlets;

import java.io.IOException;

import java.util.List;

import com.twt_foods.daoimpl.UserDAOImp;
import com.twtfoods.DAO.UserDAO;
import com.twtfoods.model.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/loginservlet")
public class Loginservlet extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		UserDAO userDAOImp = new UserDAOImp();
		
		List<User> allUsers = userDAOImp.getAllUsers();
		boolean isValid = false;
		
		for (User user : allUsers) {
			
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				
				isValid = true;
				
				break;
			}
			
		}
		
		
		
		resp.setContentType("text/html");
		
		if(isValid) {
			
			resp.sendRedirect("home");
		}
		else{
			
			
			
			resp.sendRedirect("Login.html?status=failed");
		}
		
		
		
		
	}

}
