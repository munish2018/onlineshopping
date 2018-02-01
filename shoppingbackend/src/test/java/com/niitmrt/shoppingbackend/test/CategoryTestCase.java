package com.niitmrt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitmrt.shoppingbackend.dao.CategoryDAO;
import com.niitmrt.shoppingbackend.model.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	//private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niitmrt.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	/*
	 * Testing adding catagory
	@Test
	public void testAddCategory()
	{
		Category category = new Category();
		category.setName("TV");
		category.setDescription("description of TV");
		category.setImageURL("cat1.png");
		assertEquals("Successfully added a category into table",true,categoryDAO.add(category));
	}
*/
	/*  testing getting a single category
	@Test
	public void testGetCategory()
	{
		category=categoryDAO.get(1);
		assertEquals("Successfully fetched  a category from  the table","TV",category.getName());
		
	}
	*/
	/*
	@Test
	public void testUpdateCategory()
	{
		category=categoryDAO.get(1);
		category.setName("TeleV");
		assertEquals("Successfully updated  a category from  the table",true,categoryDAO.update(category));
		
	}
*/
	/*
	@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(1);
		assertEquals("Successfully deleted  a category from  the table",true,categoryDAO.delete(category));
		
	}
	*/
	/*
	@Test
	public void testListCategory()
	{
		assertEquals("Successfully fetched  the categories from  the table",0,categoryDAO.list().size());
		
	}
	*/
	@Test
	public void testCRUDCategory()
	{
		
		// adding category into category table
		Category category = new Category();
		category.setName("Television");
		category.setDescription("description of TV");
		category.setImageURL("cat1.png");
		assertEquals("Successfully added a category into table",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("description of Mobile");
		category.setImageURL("cat2.png");
		assertEquals("Successfully added a category into table",true,categoryDAO.add(category));
		
		
		// fetching a single category from category table
		category=categoryDAO.get(1);
		assertEquals("Successfully fetched  a category from  the table","Television",category.getName());
		
		//updating a category 
		category=categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated  a category from  the table",true,categoryDAO.update(category));
		
		//delete a category
		category=categoryDAO.get(1);
		assertEquals("Successfully deleted  a category from  the table",true,categoryDAO.delete(category));
		
		// fetching the list from category
		assertEquals("Successfully fetched  the categories from  the table",1,categoryDAO.list().size());
		
	}
	
}
