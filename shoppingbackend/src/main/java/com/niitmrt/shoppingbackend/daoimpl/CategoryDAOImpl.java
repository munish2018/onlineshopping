package com.niitmrt.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niitmrt.shoppingbackend.dao.CategoryDAO;
import com.niitmrt.shoppingbackend.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>(); static {
	 * Category category = new Category(); category.setId(1);
	 * category.setName("TV"); category.setDescription("description of TV");
	 * category.setImageURL("cat1.png"); categories.add(category);
	 * 
	 * category = new Category(); category.setId(2); category.setName("Mobile");
	 * category.setDescription("description of Mobile");
	 * category.setImageURL("cat2.png"); categories.add(category);
	 * 
	 * category = new Category(); category.setId(3); category.setName("Laptop");
	 * category.setDescription("description of Laptop");
	 * category.setImageURL("cat3.png"); categories.add(category);
	 * 
	 * }
	 */

	@Override
	public Category get(int id) {
		/*
		 * for (Category category : categories) { if (category.getId() == id)
		 * return category; } return null;
		 */
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		}

	@Override

	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
