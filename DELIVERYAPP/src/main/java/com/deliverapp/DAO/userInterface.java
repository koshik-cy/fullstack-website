package com.deliverapp.DAO;

import java.util.List;

import com.deliverapp.models.User;

public interface userInterface {
	
	int addUser(User user);
	
	User getUser(int userid);
	
	void updateUser(User user);
	
	void deleteUser(int userid);
	
	List<User> getAllUsers();
	
	
	

}
