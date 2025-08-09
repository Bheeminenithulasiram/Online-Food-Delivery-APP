package com.twt_foods.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.twtfoods.DAO.UserDAO;
import com.twtfoods.model.User;
import com.twtfoods.util.DBConnections;

public class UserDAOImp implements UserDAO{


	private static String SELECT = "SELECT * from `user` where `userid` = ? ";
	private static String UPDATE = "UPDATE `user` set `name` = ? ,`username` = ? , `password` = ? , `email` = ? ,`phonenumber` = ?, `address` = ? where `userid` = ?";
	private static String INSERT = "INSERT into `user` (`userid`,`name`,`username`,`password`,`email`,`phonenumber`,`address`,`role`,`createdate`,`lastlogindate`) values(?,?,?,?,?,?,?,?,?,?)";
	private static String SELECTALL = "SELECT * from `user`";
	private static String DELETE = "DELETE from `user` where `userid` = ? ";



	@Override
	public List<User> getAllUsers() {

		User user = null;
		List<User> list  = new ArrayList<User>();
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(SELECTALL);) 
		{



			ResultSet executeQuery = preparedstatement.executeQuery();

			while(executeQuery.next()) {

				int id = executeQuery.getInt("userid");
				String name = executeQuery.getString("name");
				String userName = executeQuery.getString("username");
				String password = executeQuery.getString("password");
				String email = executeQuery.getString("email");
				String phoneNumber = executeQuery.getString("phonenumber");
				String address = executeQuery.getString("address");
				String role = executeQuery.getString("role");
				Timestamp createDate = executeQuery.getTimestamp("createdate");
				Timestamp lastLoginDate = executeQuery.getTimestamp("lastlogindate");

				user = new User(id, name, userName, password, email, phoneNumber, address, role, createDate, lastLoginDate);

				list.add(user);


			}





		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return list;




	}

	@Override
	public User getUser(int userId) {

		User user = null;
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT);) 
		{

			preparedstatement.setInt(1, userId);


			ResultSet executeQuery = preparedstatement.executeQuery();

			while(executeQuery.next()) {

				int id = executeQuery.getInt("userid");
				String name = executeQuery.getString("name");
				String userName = executeQuery.getString("username");
				String password = executeQuery.getString("password");
				String email = executeQuery.getString("email");
				String phoneNumber = executeQuery.getString("phonenumber");
				String address = executeQuery.getString("address");
				String role = executeQuery.getString("role");
				Timestamp createDate = executeQuery.getTimestamp("createdate");
				Timestamp lastLoginDate = executeQuery.getTimestamp("lastlogindate");

				user = new User(id, name, userName, password, email, phoneNumber, address, role, createDate, lastLoginDate);


			}





		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return user;




	}

	@Override
	public int addUser(User user) {
		
		int executeUpdate = 0;

		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT);) 
		{


			preparedstatement.setInt(1, user.getUserId());
			preparedstatement.setString(2, user.getName());
			preparedstatement.setString(3, user.getUserName());
			preparedstatement.setString(4, user.getPassword());
			preparedstatement.setString(5, user.getEmail());
			preparedstatement.setString(6, user.getPhoneNUmber());
			preparedstatement.setString(7, user.getAddress());
			preparedstatement.setString(8, user.getRole());
			preparedstatement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			preparedstatement.setTimestamp(10, new Timestamp(System.currentTimeMillis()));

			executeUpdate = preparedstatement.executeUpdate();

			



		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return executeUpdate;

	}

	@Override
	public void updateUser(User user) {

		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(UPDATE);) 
		{



			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getUserName());
			preparedstatement.setString(3, user.getPassword());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getPhoneNUmber());
			preparedstatement.setString(6, user.getAddress());
			preparedstatement.setInt(7, user.getUserId());

			int executeUpdate = preparedstatement.executeUpdate();

			System.out.println(executeUpdate);



		}
		catch (SQLException e) {
			e.printStackTrace();
		}




	}

	@Override
	public void deleteUser(int userId) {

		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(DELETE);){
			
			preparedstatement.setInt(1, userId);
			
			int executeQuery = preparedstatement.executeUpdate();
			
			System.out.println("Successfully deleted "+ executeQuery + " row");
			


		} catch (SQLException e) {

			e.printStackTrace();
		}


	}





}
