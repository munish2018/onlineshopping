package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(int id);
	
	
}
