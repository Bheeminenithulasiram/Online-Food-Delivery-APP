package com.twtfoods.model;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String address;
	private String cuisineType;
	private String description;
	private String deliveryTime;
	private String userId;
	private String rating;
	private String isActive;
	private String imagePath;
	
	
	public Restaurant(int restaurantId, String name, String address,String cuisineType, String description, String deliveryTime,
			String userId, String rating, String isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.cuisineType = cuisineType;
		this.description = description;
		this.deliveryTime = deliveryTime;
		this.userId = userId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddresss() {
		return address;
	}


	public void setAddresss(String addresss) {
		this.address = addresss;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	


	public String getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public String toString() {
		
		return "Restaurant: [ "+name+" ,"+ address + " "+description+" ]" ;
		
	}


	public Restaurant(String name, String address, String cuisineType, String description, String deliveryTime,
			String rating, String isActive) {
		super();
		this.name = name;
		this.address = address;
		this.cuisineType = cuisineType;
		this.description = description;
		this.deliveryTime = deliveryTime;
		this.rating = rating;
		this.isActive = isActive;
	}
	
	
	

	
}
