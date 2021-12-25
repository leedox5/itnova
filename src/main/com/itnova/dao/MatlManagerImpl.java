package com.itnova.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itnova.entities.Matl;
import com.itnova.entities.MatlPK;
import com.itnova.hibernate.HibernateUtil;

public class MatlManagerImpl implements MatlManager {

	private static final Logger logger = LoggerFactory.getLogger(MatlManagerImpl.class);
	private MatlDAO matlDAO = new MatlDAOImpl();
	
	@Override
	public Matl findMatlByID(MatlPK matlPK) {
		Matl matl = null;
		try {
			Session session = HibernateUtil.beginTransaction();
			matl = (Matl)matlDAO.findByID(session, Matl.class, matlPK);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
			throw ex;
		}
		return matl;
	}

	@Override
	public List<Matl> loadByCode(MatlPK matlPK) {
		List<Matl> matls = new ArrayList<Matl>();
		try {
			HibernateUtil.beginTransaction();
			matls = matlDAO.findByCode(matlPK);
			HibernateUtil.commitTransaction();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return matls;
	}
}
