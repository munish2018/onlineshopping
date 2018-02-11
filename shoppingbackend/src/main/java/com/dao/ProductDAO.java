package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();	
	List<Product> listbycate(int cid);
	List<Product> listbysupp(int sid);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(int productId);
}
