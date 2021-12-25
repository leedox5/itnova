package com.itnova.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itnova.dao.MdlfDAO;
import com.itnova.dao.MdlfDAOImpl;
import com.itnova.entities.Mdlf;
import com.itnova.entities.MdlfPK;

public class MdlfManagerImpl implements MdlfManager {

	private static final Logger logger = LoggerFactory.getLogger(MdlfManagerImpl.class);
	private MdlfDAO mdlfDAO = new MdlfDAOImpl();
	
	@Override
	public Mdlf findMdlfByID(MdlfPK pk) {
		Mdlf mdlf = null;
		try {
			Session session = HibernateUtil.beginTransaction();
			mdlf = (Mdlf)mdlfDAO.findByID(session, Mdlf.class, pk);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			logger.debug(ex.getMessage());
			HibernateUtil.rollbackTransaction();;
		}
		return mdlf;
	}

}
