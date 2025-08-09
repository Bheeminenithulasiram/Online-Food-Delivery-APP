import java.util.List;
import java.util.Scanner;

import com.twt_foods.daoimpl.MenuDAOImp;
import com.twtfoods.DAO.MenuDAO;
import com.twtfoods.model.Menu;

public class LaunchMenu {

	static Scanner scanner = new Scanner(System.in);

	public static void addingTheMenu() {

		System.out.println("Enter the Id of Restaurant : ");

		int restaurantId = scanner.nextInt();
		
		scanner.nextLine();

		System.out.println("Enter the name of item: ");

		String itemName = scanner.nextLine();

		System.out.println("Enter the Description :");

		String description = scanner.nextLine();

		System.out.println("Enter the Price of itenm:");

		String price = scanner.nextLine();
		
		System.out.println("Enter whether it is Available or not? :");
		
		String isAvailable = scanner.nextLine();
		
		
		System.out.println("Enter the rating :");
		
		String rating = scanner.nextLine();
		
		Menu menu = new Menu(restaurantId, itemName, description, price, isAvailable, rating);
		
		MenuDAO menuDAOImp = new MenuDAOImp();
		
		menuDAOImp.addMenu(menu);

	}
	
	public static void updatingTheMenu() {
		
		System.out.println("Enter the Id of Menu: ");
		
		int menuId = scanner.nextInt();
		
		scanner.nextLine();
		
		MenuDAO menuDAOImp = new MenuDAOImp();
		
		Menu menu = menuDAOImp.getMenu(menuId);
		
		System.out.println("Enter the Name of item :");
		
		String itemName = scanner.nextLine();
		
		menu.setItemName(itemName);
		
		menuDAOImp.updateMenu(menu);
		
	}
	
	public static void getAllTheMenu() {
		
		MenuDAO menuDAOImp = new MenuDAOImp();
		
		List<Menu> allMenu = menuDAOImp.getAllMenu();
		
		for(Menu menu : allMenu) {
			
			System.out.println(menu);
		}
		
		
	}
	
	public static void getMenuByRestaurantId() {
		
		System.out.println("Enter the restaurantId: ");
		
		int rId = scanner.nextInt();
		
		MenuDAO menuDAOImp = new MenuDAOImp();
		
		List<Menu> allMenu = menuDAOImp.getAllMenuByRestaurantId(rId);
		
		for (Menu menu : allMenu) {
			
			System.out.println(menu);
		}
		
		
		
	}

	public static void main(String[] args) {
		
		
		getMenuByRestaurantId();

	}

}
