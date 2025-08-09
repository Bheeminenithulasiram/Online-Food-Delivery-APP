package com.twt_foods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twtfoods.DAO.MenuDAO;
import com.twtfoods.model.Menu;
import com.twtfoods.util.DBConnections;

public class MenuDAOImp implements MenuDAO {

	private static String INSERT = "INSERT into `menu` (`menuId`,`restaurantId`,`itemName`,`description`,`price`,`isAvailable`,`ratings`,`imagePath`) "
			+ "values (?,?,?,?,?,?,?,?)";
	private static String SELECT = "SELECT * from `menu` where `menuId` = ? ";
	private static String UPDATE = "UPDATE `menu` set `restaurantId` = ? , `itemName` = ? , `description` = ?, `price` = ? , `isAvailable` = ? , `ratings` = ? where `menuId` = ?";
	private static String SELECTALL = "SELECT * from `menu`";
	private static String SELECTRALL = "SELECT * from `menu` where `restaurantId` = ?";

	@Override
	public List<Menu> getAllMenu() {

		Menu menu = null;

		List<Menu> list = new ArrayList<Menu>();
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL);)
		{

			ResultSet executeQuery = preparedStatement.executeQuery();

			while(executeQuery.next()) {

				int mId = executeQuery.getInt("menuId");
				int rId = executeQuery.getInt("restaurantId");
				String itemName = executeQuery.getString("itemName");
				String description = executeQuery.getString("description");
				String price = executeQuery.getString("price");
				String isAvailable = executeQuery.getString("isAvailable");
				String rating = executeQuery.getString("ratings");
				String imagePath = executeQuery.getString("imagePath");

				menu = new Menu(mId, rId, itemName, description, price, isAvailable, rating, imagePath);

				list.add(menu);

			}



		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<Menu> getAllMenuByRestaurantId(int restaurantId) {
		
		Menu menu = null;
		
		List<Menu> list = new ArrayList<Menu>();
		
		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECTRALL );)
		{
			
			preparedStatement.setInt(1, restaurantId);
			
			ResultSet executeQuery = preparedStatement.executeQuery();
			
			while(executeQuery.next()) {
				
				int mId = executeQuery.getInt("menuId");
				int rId = executeQuery.getInt("restaurantId");
				String itemName = executeQuery.getString("itemName");
				String description = executeQuery.getString("description");
				String price = executeQuery.getString("price");
				String isAvailable = executeQuery.getString("isAvailable");
				String rating = executeQuery.getString("ratings");
				String imagePath = executeQuery.getString("imagePath");

				menu = new Menu(mId, rId, itemName, description, price, isAvailable, rating, imagePath);

				list.add(menu);
				
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
	}

	@Override
	public Menu getMenu(int menuId) {

		Menu menu = null;


		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);)

		{

			preparedStatement.setInt(1, menuId);

			ResultSet executeQuery = preparedStatement.executeQuery();

			while(executeQuery.next()) {

				int mId = executeQuery.getInt("menuId");
				int rId = executeQuery.getInt("restaurantId");
				String itemName = executeQuery.getString("itemName");
				String description = executeQuery.getString("description");
				String price = executeQuery.getString("price");
				String isAvailable = executeQuery.getString("isAvailable");
				String rating = executeQuery.getString("ratings");
				String imagePath = executeQuery.getString("imagePath");

				menu = new Menu(mId, rId, itemName, description, price, isAvailable, rating, imagePath);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return menu;



	}

	@Override
	public void addMenu(Menu menu) {

		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			preparedStatement.setInt(1, menu.getMenuId());
			preparedStatement.setInt(2, menu.getRestaurantId());
			preparedStatement.setString(3, menu.getItemName());
			preparedStatement.setString(4, menu.getDescription());
			preparedStatement.setString(5, menu.getPrice());
			preparedStatement.setString(6, menu.getIsAvailable());
			preparedStatement.setString(7, menu.getRatings());
			preparedStatement.setString(8, menu.getImagePath());


			int executeUpdate = preparedStatement.executeUpdate();

			System.out.println("Succesfully inserted "+ executeUpdate + " row");


		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateMenu(Menu menu) {

		try(Connection connection = DBConnections.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
		{

			preparedStatement.setInt(1, menu.getRestaurantId());
			preparedStatement.setString(2, menu.getItemName());
			preparedStatement.setString(3, menu.getDescription());
			preparedStatement.setString(4, menu.getPrice());
			preparedStatement.setString(5, menu.getIsAvailable());
			preparedStatement.setString(6, menu.getRatings());
			preparedStatement.setInt(7, menu.getMenuId());

			int executeUpdate = preparedStatement.executeUpdate();

			System.out.println("Successfully Updated " + executeUpdate + " row");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub

	}




}
