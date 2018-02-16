package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDAO;
import com.model.Cart;

@Repository("cartDAO")
@Transactional
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
	public List<Cart> findcartbyid(String uemail) {
		// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	List<Cart> cr=null;
	try
	{
		session.beginTransaction();
		cr=(List<Cart>)session.createQuery("from Cart where useremail=:email").setString("email",uemail).list();
		session.getTransaction().commit();
		return cr;
		}
	catch(HibernateException ex)
	{
		ex.printStackTrace();
		session.getTransaction().rollback();
	}
	return cr;
	}

	@Override
	public Cart getcartbyid(int cartid, String uemail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Cart cr=null;
		session.beginTransaction();
		cr=(Cart)session.createQuery("from Cart where useremail=:email and cartproductid=:id")
				.setString("email", uemail)
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
