package com.daoimpl;

import java.util.List;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SupplierDAO;
import com.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Supplier get(int sid) {
		return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(sid));
	}

	@Override
	public List<Supplier> list() {
		Session session = sessionFactory.openSession();
		List<Supplier> list=session.createQuery("from Supplier").list();
		session.close();
		return list;

	}

	@Override
	public boolean add(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int sid) {
		try {
			sessionFactory.getCurrentSession().remove(get(sid));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

