package com.twtfoods.DAO;


import java.util.List;

import com.twtfoods.model.User;

public interface UserDAO {
	
	List<User> getAllUsers();
	
	User getUser(int userId);
	
	int addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int userId);

}
