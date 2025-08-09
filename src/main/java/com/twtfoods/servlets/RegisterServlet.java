package com.twtfoods.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.twt_foods.daoimpl.UserDAOImp;
import com.twtfoods.DAO.UserDAO;
import com.twtfoods.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String number = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		
		User user = new User(name, username, password, email, number, address, role);
		UserDAO userDAOImp = new UserDAOImp();
		
		int result = userDAOImp.addUser(user);
		
		
		
		PrintWriter out = resp.getWriter();
		
		if(result >= 1) {
			
			
			
			resp.sendRedirect("Registration.html?status=success");
			

		}else {
			
			resp.sendRedirect("Registration.html?status=failure");

		}
		
		
		
	}

}
