package kr.co.itnova.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("> Initial SessionFactory creation failed. \n" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
        return sessionFactory.getCurrentSession();
	}

	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}
	
	public static void closeSession() {
		HibernateUtil.getSession().close();
	}
}
