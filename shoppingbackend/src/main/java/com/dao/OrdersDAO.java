package com.dao;

import java.util.List;

import com.model.Orders;

public interface OrdersDAO {
	public void insert(Orders orders);
	public List<Orders> listorderbyid(String useremail);
	public Orders findorderbyid(String useremail);
	public Orders getorderbyid(int orderid,String useremail);
	public void deleteorder(int orderid);
	public void update(Orders orders);
}
