package com.itnova.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itnova.dao.SimmDAO;
import com.itnova.dao.SimmDAOImpl;
import com.itnova.entities.Simm;
import com.itnova.entities.SimmPK;

public class SimmManagerImpl implements SimmManager {

	private static final Logger logger = LoggerFactory.getLogger(SimmManagerImpl.class);
	private SimmDAO simmDAO = new SimmDAOImpl();
	
	@Override
	public Simm findSimmByID(SimmPK pk) {
		Simm simm = null;
		try {
			Session session = HibernateUtilBatch.beginTransaction();
			simm = (Simm)simmDAO.findByID(session, Simm.class, pk);
			HibernateUtilBatch.commitTransaction();
		} catch(HibernateException ex) {
			logger.debug(ex.getMessage());
			HibernateUtilBatch.rollbackTransaction();
		}
		return simm;
	}
}
