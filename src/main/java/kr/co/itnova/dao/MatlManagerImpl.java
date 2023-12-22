package kr.co.itnova.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.itnova.entities.Matl;
import kr.co.itnova.entities.MatlPK;
import kr.co.itnova.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatlManagerImpl implements MatlManager {

	private static final Logger logger = LoggerFactory.getLogger(MatlManagerImpl.class);
	private MatlDAO matlDAO = new MatlDAOImpl(HibernateUtil.getSession());
	
	@Override
	public Matl findMatlByID(MatlPK matlPK) {
		Matl matl = null;
		try {
			Session session = HibernateUtil.beginTransaction();
			matl = (Matl)matlDAO.findByID(Matl.class, matlPK);
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
