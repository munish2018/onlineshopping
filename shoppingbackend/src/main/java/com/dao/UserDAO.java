package com.dao;

import com.model.User;

public interface UserDAO {

	// user related operation
		User getByEmail(String email);
		User get(int id);
		boolean add(User user);	
	
}
