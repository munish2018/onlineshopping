package com.daoimpl;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDAO;
import com.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category ";//WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		//query.setParameter("active", true);
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
	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().remove(get(id));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
