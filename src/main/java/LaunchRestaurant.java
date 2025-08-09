import java.util.List;
import java.util.Scanner;

import com.twt_foods.daoimpl.RestaurantDAOImp;
import com.twtfoods.DAO.RestaurantDAO;
import com.twtfoods.model.Restaurant;

public class LaunchRestaurant {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void addingTheRestaurant() {
		
		System.out.println("Enter the Restaurant name: ");
		String name = scanner.nextLine();
		System.out.println("Enter the Restaurant address: ");
		String address = scanner.nextLine();
		System.out.println("Enter the Restaurant cuisineType: ");
		String cuisineType = scanner.nextLine();
		System.out.println("Enter the Restaurant Description: ");
		String description = scanner.nextLine();
		System.out.println("Enter the Restaurant DeliveryTime: ");
		String deliveryTime = scanner.nextLine();
		System.out.println("Enter the Restaurant rating: ");
		String rating = scanner.nextLine();
		
		System.out.println("Enter the Restaurant isActive: ");
		String isActive = scanner.nextLine();
		
		
		Restaurant restaurant = new Restaurant(name, address, cuisineType,description, deliveryTime, rating, isActive);
		
		RestaurantDAO restaurantDAOImp = new RestaurantDAOImp();
		
		restaurantDAOImp.addRestaurant(restaurant);
		
		
	}
	
	public static void updatingTheRestaurant(){
		
		
		int id = scanner.nextInt();
		
		scanner.nextLine();
		
		RestaurantDAO restaurantDAOImp = new RestaurantDAOImp();
		
		Restaurant restaurant =	restaurantDAOImp.getRestaurant(id);
		
		System.out.println("Enter the name of restaurant");
		
		String name = scanner.nextLine();
		
		restaurant.setName(name);
		
		restaurantDAOImp.updateRestaurant(restaurant);
		
		
	}
	
	public static void gettingAllTheRestaurant() {
		
		
		RestaurantDAO restaurantDAOImp = new RestaurantDAOImp();
		
		List<Restaurant> allRestaurant = restaurantDAOImp.getAllRestaurants();
		
		for(Restaurant restaurant : allRestaurant ) {
			
			System.out.println(restaurant);
		}
		
		
	}
	
	public static void deletingTheRestaurant() {
		
		
		int num = scanner.nextInt();
		
		RestaurantDAO restaurantDAOImp = new RestaurantDAOImp();
		
		restaurantDAOImp.deleteRestaurant(num);
		
		
		
	}

	public static void main(String[] args) {
		
		addingTheRestaurant();

	}

}
