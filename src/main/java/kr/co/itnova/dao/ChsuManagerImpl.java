package kr.co.itnova.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.itnova.entities.Chsu;
import kr.co.itnova.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChsuManagerImpl implements ChsuManager {

	private static final Logger logger = LoggerFactory.getLogger(ChsuManagerImpl.class);
	private ChsuDAO chsuDAO = new ChsuDAOImpl();
	
	@Override
	public void saveNewChsu(Chsu chsu) {
		try {
			HibernateUtil.beginTransaction();
			chsuDAO.save(chsu);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}
	}

	@Override
	public Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode) {
		Integer maxSeq = null;
		try {
			HibernateUtil.beginTransaction();
			maxSeq = chsuDAO.getMaxSeq(corpCode, vendCode, partNo, pvendCode);
			HibernateUtil.commitTransaction();
		}catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}
		return maxSeq;
	}

	@Override
	public List<Chsu> loadFinished() {
		List<Chsu> chsus = new ArrayList<Chsu>();
		String sql = "FROM Chsu t WHERE stat = 'F' ";
		try {
			HibernateUtil.beginTransaction();
			Query query = HibernateUtil.getSession().createQuery(sql);
			chsus = chsuDAO.findMany(query);
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return chsus;
	}
}
