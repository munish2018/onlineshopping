package com.niitmrt.shoppingbackend.dao;

import java.util.List;

import com.niitmrt.shoppingbackend.model.*;

public interface SupplierDAO {

	Supplier get(int sid);
	List<Supplier> list();
	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(Supplier supplier);
	
}
