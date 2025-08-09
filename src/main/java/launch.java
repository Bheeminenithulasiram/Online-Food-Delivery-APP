import java.util.List;
import java.util.Scanner;

import com.twt_foods.daoimpl.UserDAOImp;
import com.twtfoods.DAO.UserDAO;
import com.twtfoods.model.User;

public class launch {

	static Scanner scanner = new Scanner(System.in);


	public static void addingTheUser() {

		System.out.println("Enter the name:");
		String name = scanner.next();
		System.out.println("Enter the username:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		System.out.println("Enter the email:");
		String email = scanner.next();
		System.out.println("Enter the phone number:");
		String phoneNumber = scanner.next();
		System.out.println("Enter the address:");
		String address = scanner.next();
		System.out.println("Enter the role:");
		String role = scanner.next();

		User user = new User(name, userName, password, email, phoneNumber, address, role);

		UserDAO impl = new UserDAOImp();

		impl.addUser(user);


	}

	public static void updatingTheUser() {


		int id  = scanner.nextInt();

		UserDAO userDAOImp = new UserDAOImp();

		User user = userDAOImp.getUser(id);
		
		user.setPassword("4578");

		userDAOImp.updateUser(user);



	}

	public static void gettingAllTheUser() {

		UserDAO impl = new UserDAOImp();

		List<User> allusers = impl.getAllUsers();

		for(User user : allusers) {
			
			System.out.println(user);
		}


	}

	public static void deletingTheUser() {

		int id = scanner.nextInt(); 

		UserDAOImp impl = new UserDAOImp();


		impl.deleteUser(id);




	}
	
	public static void gettingTheUser() {
		
		int id = scanner.nextInt();
		
		UserDAO userDAOImpl = new UserDAOImp();
		
		userDAOImpl.getUser(id);
		
		
	}


	public static void main(String[] args) {
		
		
		gettingAllTheUser();
		


		scanner.close();


	}

}
