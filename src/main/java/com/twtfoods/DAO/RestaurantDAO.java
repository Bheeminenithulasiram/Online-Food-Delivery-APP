package com.twtfoods.DAO;

import java.util.List;

import com.twtfoods.model.Restaurant;

public interface RestaurantDAO {
	
	List<Restaurant> getAllRestaurants();
	
	Restaurant getRestaurant(int resaturantId);
	
	void addRestaurant(Restaurant restaurant);
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(int resaturantId);
	

}
