package com.niitmrt.shoppingbackend.dao;

import java.util.List;

import com.niitmrt.shoppingbackend.model.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	
}
