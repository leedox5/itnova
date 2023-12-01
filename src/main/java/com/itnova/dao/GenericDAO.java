package com.itnova.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public interface GenericDAO<T, PK extends Serializable> {
	public void save(T entity);
	public void save(Session session, T entity);
	public PK saveOnly(Session session, T entity);
	public T findByID(Session session, Class<?> clazz, PK id);
	public List<T> findAll(Class<T> clazz);
	public List<T> findMany(Query query);
}
