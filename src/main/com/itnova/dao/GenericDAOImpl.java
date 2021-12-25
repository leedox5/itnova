package com.itnova.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.itnova.hibernate.HibernateUtil;

public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{
	
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	
	public void save(T entity) {
		Session session = this.getSession();
		session.saveOrUpdate(entity);
	}

	public void save(Session session, T entity) {
		session.saveOrUpdate(entity);
	}

	
	@SuppressWarnings("unchecked")
	public PK saveOnly(Session session, T entity) {
		PK pk = null;
		pk = (PK)session.save(entity);
		return pk;
	}
	
	@SuppressWarnings("unchecked")
	public T findByID(Session session, Class<?> entity, PK id) {
		T t = null;
		t = (T) session.get(entity, id);
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz) {
		Session session = this.getSession();
		List<T> t = null;
		Query query = session.createQuery("from " + clazz.getName());
		t = query.list();
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}
}
