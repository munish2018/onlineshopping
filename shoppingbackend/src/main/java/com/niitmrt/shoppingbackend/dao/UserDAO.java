package com.niitmrt.shoppingbackend.dao;

import com.niitmrt.shoppingbackend.model.User;

public interface UserDAO {

	// user related operation
		User getByEmail(String email);
		User get(int id);
		boolean add(User user);	
	
}
