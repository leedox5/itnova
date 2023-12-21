package kr.co.itnova.hibernate;

import kr.co.itnova.dao.MdlfDAO;
import kr.co.itnova.dao.MdlfDAOImpl;
import kr.co.itnova.entities.Mdlf;
import kr.co.itnova.entities.MdlfPK;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
