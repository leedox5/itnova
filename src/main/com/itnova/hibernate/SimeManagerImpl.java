package com.itnova.hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itnova.dao.SimeDAO;
import com.itnova.dao.SimeDAOImpl;
import com.itnova.entities.Sime;
import com.itnova.entities.SimePart;
import com.itnova.entities.Simm;
import com.itnova.util.DateUtil;

public class SimeManagerImpl implements SimeManager {

	private static final Logger logger = LoggerFactory.getLogger(SimeManagerImpl.class);
	private SimeDAO simeDAO = new SimeDAOImpl();
	
	@Override
	public List<Sime> loadAllByMnge(String mngeNo) {
		List<Sime> simes = new ArrayList<Sime>();
		try {
			Session session = HibernateUtilBatch.beginTransaction();
			Query query = session.createQuery(String.format("SELECT DISTINCT simePK.partNo FROM Sime WHERE simePK.corpCode='K001' AND simePK.mngeNo = '%s'",mngeNo));
			simes = simeDAO.findMany(query);
			HibernateUtilBatch.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtilBatch.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return simes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimePart> loadAllByMngeNo(String mngeNo) {
		List<SimePart> simes = null;
		try {
			Session session = HibernateUtilBatch.beginTransaction();
			Criteria cr = session.createCriteria(Sime.class);
			
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.property("simePK.partNo"),"partNo");
			projList.add(Projections.property("cretGubn"),"cretGubn");
			
			cr.setProjection(Projections.distinct(projList));
			cr.add(Restrictions.eq("simePK.corpCode", "K001"));
			cr.add(Restrictions.eq("simePK.mngeNo", mngeNo));
			
			cr.setResultTransformer(Transformers.aliasToBean(SimePart.class));
			
			simes = cr.list();
			HibernateUtilBatch.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtilBatch.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return simes;
	}

	public void runProc70(final String partNo, final Simm simm) {
		try {
			Session session = HibernateUtilBatch.beginTransaction();
			session.doWork(new Work() {
				@Override
				public void execute(Connection con) throws SQLException {
					CallableStatement cstmt = null;

					//70
					long startTime = System.currentTimeMillis();
					String startTimeStr = String.format("%s-%s", DateUtil.getToday(), DateUtil.getTime());
					String partInfo = String.format("%s-%s", simm.getSimmPK().getMngeNo(), partNo);
					
					cstmt = con.prepareCall("{CALL RMSFLE.SPRD10CT70(?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, "2");
					cstmt.setString(2, "ALL");
					cstmt.setString(3, simm.getInitCman());
					cstmt.setString(4, simm.getSimmPK().getCorpCode());
					cstmt.setString(5, simm.getSimmPK().getMngeNo());
					cstmt.setString(6, partNo);
					cstmt.registerOutParameter( 7, Types.VARCHAR);
					cstmt.registerOutParameter( 8, Types.VARCHAR);
					cstmt.registerOutParameter( 9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);

					cstmt.executeUpdate();
					
					String code = cstmt.getString(7);
					String msg = cstmt.getString(8);

					if(code.equals("SA-001") == false) {
						logger.debug("Error:[{}]{}", code, msg);
					} else { 
						//String endTimeStr = String.format("%s-%s", DateUtil.getToday(), DateUtil.getTime());
						//logger.debug("{}:70[{}~{}][{}]", partInfo, startTimeStr, endTimeStr, (System.currentTimeMillis() - startTime)/1000);
					}
					cstmt.close();
					//80
					//startTime = System.currentTimeMillis();
					//startTimeStr = String.format("%s-%s", DateUtil.getToday(), DateUtil.getTime());
					
					cstmt = con.prepareCall("{CALL RMSFLE.SPRD10CT80(?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, "2");
					cstmt.setString(2, simm.getInitCman());
					cstmt.setString(3, simm.getSimmPK().getCorpCode());
					cstmt.setString(4, simm.getSimmPK().getMngeNo());
					cstmt.setString(5, "");
					cstmt.setString(6, "");
					cstmt.setString(7, partNo);
					cstmt.registerOutParameter( 8, Types.VARCHAR);
					cstmt.registerOutParameter( 9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);
					cstmt.registerOutParameter(12, Types.VARCHAR);

					cstmt.executeUpdate();

					code = cstmt.getString(8);
					msg = cstmt.getString(9);

					if(code.equals("SA-001") == false) {
						logger.debug("80-Error:[{}]{}", code, msg + cstmt.getString(11)+cstmt.getString(12));
					} else { 
						//String endTimeStr = String.format("%s-%s", DateUtil.getToday(), DateUtil.getTime());
						logger.debug("{}:80[{}]", partInfo, (System.currentTimeMillis() - startTime)/1000);
					}

				}
			});
			HibernateUtilBatch.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtilBatch.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimePart> loadAllByVendCode(String mngeNo, String vendCode) {
		List<SimePart> simes = null;
		try {
			Session session = HibernateUtil.beginTransaction();
			Criteria cr = session.createCriteria(Sime.class);
			
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.property("simePK.partNo"),"partNo");
			projList.add(Projections.property("causLkcd"),"causLkcd");
			
			cr.setProjection(Projections.distinct(projList));
			cr.add(Restrictions.eq("simePK.corpCode", "K001"));
			cr.add(Restrictions.eq("simePK.mngeNo", mngeNo));
			if(vendCode.isEmpty() == false) {
				cr.add(Restrictions.eq("vendCode", vendCode));
			}
			
			cr.setResultTransformer(Transformers.aliasToBean(SimePart.class));
			
			simes = cr.list();
			HibernateUtil.commitTransaction();
		} catch(HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			logger.debug(ex.getMessage());
		}
		return simes;
	}

	@Override
	public SimePart find(String id, List<SimePart> simeList) {
		for(SimePart sp : simeList) {
			if(sp.getPartNo().equals(id)) {
				return sp;
			}
		}
		return null;
	}

}
