package com.twtfoods.DAO;

import java.util.List;

import com.twtfoods.model.Menu;

public interface MenuDAO {
	
	List<Menu> getAllMenu();
	
	Menu getMenu(int menuId);
	
	void addMenu(Menu menu);
	
	void updateMenu(Menu menu);
	
	void deleteMenu(int menuId);
	
	List<Menu> getAllMenuByRestaurantId(int restaurantId);

}
