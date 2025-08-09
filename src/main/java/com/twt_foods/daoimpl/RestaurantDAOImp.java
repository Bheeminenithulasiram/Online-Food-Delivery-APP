package com.twt_foods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twtfoods.DAO.RestaurantDAO;
import com.twtfoods.model.Restaurant;
import com.twtfoods.util.DBConnections;

public class RestaurantDAOImp implements RestaurantDAO {

	private static String INSERT = "INSERT into `restaurant` (`restaurantId`,`name`,`address`,`cuisineType`,`description`,`deliveryTime`,`UserId`,`rating`,`isActive`,`imagePath`)"
			+ "values (?,?,?,?,?,?,?,?,?,?)";
	private static String UPDATE = "UPDATE `Restaurant` set `name` = ? , `address` = ? , `cuisineType` = ? ,`description` = ? , `deliveryTime` = ? , `userId` = ? , `rating` = ? , `isActive` = ? where `restaurantId` = ?";
	private static String SELECT = "SELECT * from `restaurant` where `restaurantId` = ? ";
	private static String SELECTALL = "SELECT * from `restaurant`";
	private static String DELETE = "DELETE from `restaurant` where `restaurantId` = ?";

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		Restaurant restaurant = null;
		
		List<Restaurant> list = new ArrayList<Restaurant>();
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(SELECTALL );)
		{
			
			ResultSet res = preparedstatement.executeQuery();
			
			while(res.next()) 
			
			{

				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String address = res.getString("address");
				String cuisineType = res.getString("cuisineType");
				String description = res.getString("description");
				String deliveryTime = res.getString("deliveryTime");
				String userId = res.getString("userId");
				String rating = res.getString("rating");
				String isActive = res.getString("isActive");
				String imagePath = res.getString("imagePath");
				
				restaurant = new Restaurant(id, name, address, cuisineType,description, deliveryTime, userId, rating, isActive, imagePath);
				
				list.add(restaurant);
				
			}
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return list;
		
		
		
		
		
	}

	@Override
	public Restaurant getRestaurant(int resaturantId) {
		
		Restaurant restaurant = null;
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT );)
		{
			
			preparedstatement.setInt(1, resaturantId);
			
			ResultSet executeQuery = preparedstatement.executeQuery();
			
			while(executeQuery.next()) {
				
				int id = executeQuery.getInt("restaurantId");
				String name = executeQuery.getString("name");
				String address = executeQuery.getString("address");
				String cuisineType = executeQuery.getString("cuisineType");
				String description = executeQuery.getString("description");
				String deliveryTime = executeQuery.getString("deliveryTime");
				String userId = executeQuery.getString("userId");
				String rating = executeQuery.getString("rating");
				String isActive = executeQuery.getString("isActive");
				String imagePath = executeQuery.getString("imagePath");
				
				restaurant = new Restaurant(id, name, address, cuisineType, description, deliveryTime, userId, rating, isActive, imagePath);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return restaurant;
		
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT);)
		{
			
			
			preparedstatement.setInt(1, restaurant.getRestaurantId());
			preparedstatement.setString(2, restaurant.getName());
			preparedstatement.setString(3, restaurant.getAddresss());
			preparedstatement.setString(4, restaurant.getCuisineType());
			preparedstatement.setString(5, restaurant.getDescription());
			preparedstatement.setString(6, restaurant.getDeliveryTime());
			preparedstatement.setString(7, restaurant.getUserId());
			preparedstatement.setString(8, restaurant.getRating());
			preparedstatement.setString(9, restaurant.getIsActive());
			preparedstatement.setString(10, restaurant.getImagePath());
			
			int executeUpdate = preparedstatement.executeUpdate();
			
			System.out.println(executeUpdate + " row updated Successfully");
			
			
			
		}
		catch(SQLException e) {
			
			
			
		}
		
		
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
		{
			
			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddresss());
			preparedStatement.setString(3, restaurant.getCuisineType());
			preparedStatement.setString(4, restaurant.getDescription());
			preparedStatement.setString(5, restaurant.getDeliveryTime());
			preparedStatement.setString(6, restaurant.getUserId());
			preparedStatement.setString(7, restaurant.getRating());
			preparedStatement.setString(8, restaurant.getIsActive());
			preparedStatement.setInt(9, restaurant.getRestaurantId());
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			System.out.println(executeUpdate);
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		

	}

	@Override
	public void deleteRestaurant(int resaturantId) {
		
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE );)
		
		{
			
			preparedStatement.setInt(1, resaturantId);
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			System.out.println("Successfully deleted "+executeUpdate+ " row");
			
		} 
		
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		

	}

}
