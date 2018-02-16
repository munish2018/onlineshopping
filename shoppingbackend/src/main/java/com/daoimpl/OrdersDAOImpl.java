package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrdersDAO;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;
import com.model.Product;

@Repository("ordersDAO")
@Transactional
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public OrdersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public void insert(Orders orders) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(orders);
			} 
		catch (Exception ex) {
			ex.printStackTrace();
			}
		}

	@Override
	public List<Orders> listorderbyid(String uemail) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		List<Orders> ord=null;
		session.beginTransaction();
		ord=(List<Orders>)session.createQuery("from Orders where orderemail=:email")
				.setString("email", uemail).list();
		if(ord==null)
			System.out.println("order list not found");
		else
			System.out.println("order list  found");
		session.getTransaction().commit();
			return ord;
		}

	@Override
	public Orders findorderbyid(String uemail) {
		/*
		Session session=sessionFactory.openSession();
		Orders ord=null;
		session.beginTransaction();
		ord=(Orders)session.createQuery("from Orders where orderemail=:email")
				.setString("email", uemail)
				.uniqueResult();
			session.getTransaction().commit();
			return ord;
			*/
		Session session =sessionFactory.openSession();
		Orders li=null;
		session.beginTransaction();
		li=(Orders)session.createQuery("from Orders where orderemail='"+uemail+"'").uniqueResult();
		session.getTransaction().commit();
		return li;
		}

	@Override
	public Orders getorderbyid(int orderid, String useremail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Orders ord=null;
		session.beginTransaction();
		ord=(Orders)session.createQuery("from Orders where orderemail=:email and orderid=:id")
				.setString("email", useremail)
				.setInteger("id",orderid).uniqueResult();
				session.getTransaction().commit();
				return ord;
	}

	@Override
	public void deleteorder(int orderid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Orders ord=(Orders)session.get(Orders.class, orderid);
		session.delete(ord);
		session.getTransaction().commit();
	}

	@Override
	public void update(Orders orders) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(orders);
			} 
		catch (Exception ex) {
			ex.printStackTrace();
			}
	}
}
