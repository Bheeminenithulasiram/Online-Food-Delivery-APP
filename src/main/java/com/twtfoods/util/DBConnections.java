package com.twtfoods.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
	
	private static String URL = "jdbc:mysql://localhost:3306/twt_foods";
	private static String USER = "root";
	private static String PASSWORD = "root";
	private static Connection connection;
	
	public static Connection getConnection(){
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
