package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.CartDAO;
import com.model.Cart;

public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		}

	@Override
	public List<Cart> findcartbyid(String useremail) {
		// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	List<Cart> cr=null;
	try
	{
		session.beginTransaction();
		cr=(List<Cart>)session.createQuery("from cart where useremail=:email").setString("email",useremail);
		session.getTransaction();
		}
	catch(HibernateException ex)
	{
		ex.printStackTrace();
		session.getTransaction().rollback();
	}
	return cr;
	}

	@Override
	public Cart getcartbyid(int cartid, String useremail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Cart cr=null;
		session.beginTransaction();
		cr=(Cart)session.createQuery("from Cart where useremail=:email and cartproductid=:id")
				.setString("email", useremail)
				.setInteger("id",cartid).uniqueResult();
				session.getTransaction().commit();
				return cr;
	}

	@Override
	public void deletecart(int cartid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class, cartid);
		session.delete(cr);
		session.getTransaction().commit();
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
	}

}
