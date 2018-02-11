package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();

	}
	@Override
	public List<Product> listbycate(int cid)
	{
		Session session =sessionFactory.openSession();
		List<Product> li=null;
		session.beginTransaction();
		li=session.createQuery("from Product where cid="+cid).list();
		session.getTransaction().commit();
		return li;
	}
	@Override
	public List<Product> listbysupp(int sid)
	{
		Session session =sessionFactory.openSession();
		List<Product> li=null;
		session.beginTransaction();
		li=session.createQuery("from Product where sid="+sid).list();
		session.getTransaction().commit();
		return li;
	}
	

	@Override
	public boolean add(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		

	}

	@Override
	public boolean delete(int productId) {
		try {
			sessionFactory.getCurrentSession().remove(get(productId));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}
}
