package kr.co.itnova.dao;

import java.io.Serializable;
import java.util.List;

import kr.co.itnova.hibernate.HibernateUtil;
import kr.co.itnova.hibernate.HibernateUtilLocal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

	protected Session session;

	public GenericDAOImpl(Session session) {
		this.session = session;
	}

	public GenericDAOImpl() {

	}

	protected Session getSession() {
		return session;
	}
	
	public void save(T entity) {
		Transaction transaction = null;

		try (Session session = HibernateUtilLocal.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			transaction.commit();
		} catch( Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
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
	public T findByID(Class<?> entity, PK id) {
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
