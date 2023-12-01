package com.itnova.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itnova.entities.Chms;
import com.itnova.entities.ChmsPK;
import com.itnova.hibernate.HibernateUtil;


public class ChmsManagerImpl implements ChmsManager {

	private static final Logger logger = LoggerFactory.getLogger(ChmsManagerImpl.class);
	
	private ChmsDAO chmsDAO = new ChmsDAOImpl();

	@Override
	public void saveNewChms(Chms chms) throws Exception {
		try {
			HibernateUtil.beginTransaction();
			chmsDAO.save(chms);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
			throw new Exception();
		}
	}

	@Override
	public Chms findChmsByID(ChmsPK chmsPk) {
		Chms chsu = null;
		try {
			Session session = HibernateUtil.beginTransaction();
			chsu = (Chms)chmsDAO.findByID(session, Chms.class, chmsPk);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return chsu;
	}

	@Override
	public List<Chms> loadAllChms() {
		List<Chms> allChms = new ArrayList<Chms>();
		try {
			HibernateUtil.beginTransaction();
			allChms = chmsDAO.findAll(Chms.class);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			logger.debug(ex.getMessage());
		}
		
		return allChms;
	}

	@Override
	public List<Chms> loadAllByDel() {
		List<Chms> allChms = new ArrayList<Chms>();
		try {
			HibernateUtil.beginTransaction();
			allChms = chmsDAO.findAllAlive(Chms.class);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			logger.debug(ex.getMessage());
		}
		
		return allChms;
	}
}
