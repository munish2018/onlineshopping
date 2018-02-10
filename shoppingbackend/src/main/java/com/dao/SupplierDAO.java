package com.dao;

import java.util.List;

import com.model.*;

public interface SupplierDAO {

	Supplier get(int sid);
	List<Supplier> list();
	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(int sid);
	
}
