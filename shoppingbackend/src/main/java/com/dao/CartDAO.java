package com.dao;

import java.util.List;

import com.model.Cart;

public interface CartDAO {

	public void insert(Cart cart);
	public List<Cart> findcartbyid(String useremail);
	public Cart getcartbyid(int cartid,String useremail);
	public void deletecart(int cartid);
	public void update(Cart cart);
	
}
