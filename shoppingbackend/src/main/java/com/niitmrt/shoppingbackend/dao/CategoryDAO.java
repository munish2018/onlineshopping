package com.niitmrt.shoppingbackend.dao;

import java.util.List;

import com.niitmrt.shoppingbackend.model.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}