package com.niitmrt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SupplierDAO;
import com.model.Supplier;

public class SupplierTestCase {

	private static AnnotationConfigApplicationContext context;

	private static SupplierDAO supplierDAO;

	private Supplier supplier;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitmrt.shoppingbackend");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	public void testCRUDSupplier() {

		// adding supplier detail  into supplier table
		
		supplier = new Supplier();
		supplier.setSupname("vijay");
		assertEquals("Successfully added a supplier into table", true, supplierDAO.add(supplier));
		supplier = new Supplier();
		supplier.setSupname("rama");
		assertEquals("Successfully added a supplier into table", true, supplierDAO.add(supplier));
     
		 
		 // fetching a single supplier detail from Supplier table
		 supplier=supplierDAO.get(1);
		 assertEquals("Successfully fetched  a supplier from  the table","vijay",supplier.getSupname());
		 
		 
		  //updating a supplier
		  supplier=supplierDAO.get(1);
		  supplier.setSupname("dinanath");
		  assertEquals("Successfully updated  a supplier from  the table",true, supplierDAO.update(supplier));
		  
		  //delete a supplier
		  supplier=supplierDAO.get(1);
		  assertEquals("Successfully deleted  a supplier from  the table",true,supplierDAO.delete(1));
		  
		 // fetching the list from supplier
		 assertEquals("Successfully fetched  the supplier details from  the table",1 ,supplierDAO.list().size());
		 
	}
}
