package kr.co.itnova.hibernate;

import java.util.List;
import java.util.Map;


import kr.co.itnova.util.DateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatestEndPartManagerImpl implements LatestEndPartManager {

	public static final Logger logger = LoggerFactory.getLogger(LatestEndPartManagerImpl.class);

	@Override
	public void findAllEndPart() {
		
	}

	@Override
	public Integer insertBulk(String inDate) {
		Session session = HibernateUtilBatch.getSessionFactory().openSession();
		Transaction tx = null;
		StringBuffer sql = new StringBuffer();
		int rowCount = 0;
		if(inDate == null) inDate = "%";
		
		sql.append("SELECT                                                                 \n");
		sql.append("        APPR_FINI_DATE                                LTEM_APPR_DATE   \n");
		sql.append("    ,   EMST_CORP_CODE                                LTEM_CORP_CODE   \n");
		sql.append("    ,   EMST_COST_GUBN                                LTEM_COST_GUBN   \n");
		sql.append("    ,   EMST_PART_NO                                  LTEM_PART_NO     \n");
		sql.append("    ,   EMST_EONO                                     LTEM_EONO        \n");
		sql.append("    ,   EMST_CUMT_NO                                  LTEM_CUMT_NO     \n");
		sql.append("    ,   EMST_INIT_CMAN                                LTEM_INIT_CMAN   \n");
		sql.append("    ,   VARCHAR_FORMAT(CURRENT TIMESTAMP, 'YYYYMMDD') LTEM_UPDT_DATE   \n");
		sql.append("FROM                                                                   \n");
		sql.append("(                                                                      \n");
		sql.append("    SELECT  BB.APPR_FINI_DATE                                          \n");
		sql.append("        ,   ROW_NUMBER() OVER                                          \n");
		sql.append("            (                                                          \n");
		sql.append("                PARTITION BY                                           \n");
		sql.append("                        EMST_CORP_CODE                                 \n");
		sql.append("                    ,   EMST_COST_GUBN                                 \n");
		sql.append("                    ,   EMST_PART_NO                                   \n");
		sql.append("                    ,   EMST_VEND_CODE                                 \n");
		sql.append("                ORDER BY                                               \n");
		sql.append("                        BB.APPR_FINI_DATE DESC                         \n");
		sql.append("                    ,   EMST_EXTR_SEQ0    DESC                         \n");
		sql.append("            ) RNO                                                      \n");
		sql.append("        ,   AA.*                                                       \n");
		sql.append("    FROM   RMSFLE.PFRCEMST AA                                          \n");
		sql.append("    JOIN   RMSFLE.PFRCAPPR BB                                          \n");
		sql.append("    ON     AA.EMST_CORP_CODE = BB.APPR_CORP_CODE                       \n");
		sql.append("    AND    AA.EMST_APPR_NO   = BB.APPR_NO                              \n");
		sql.append("    WHERE  AA.EMST_COST_GUBN = 'RD'                                    \n");
		sql.append("    AND    AA.EMST_BUMN_GUBN = 'D'                                     \n");
		sql.append("    AND    AA.EMST_PASS_STAT = '4'                                     \n");
		sql.append("    AND    EMST_EXTR_SEQ0    < 7000                                    \n");
		sql.append(")X                                                                     \n");
		sql.append("WHERE RNO = 1                                                          \n");
		sql.append(String.format("  AND APPR_FINI_DATE LIKE '%s'                                      \n", inDate));  
		//sql.append("AND   APPR_FINI_DATE = VARCHAR_FORMAT(CURRENT TIMESTAMP - 1 DAYS, 'YYYYMMDD')  \n");
		
		logger.debug("S: " + DateUtil.getTime());
		try {
			tx = session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<?> data = sqlQuery.list();

			for(Object object : data) {
				Map<?,?> row = (Map<?, ?>)object;
				
				LatestEndPart emst = new LatestEndPart();
				emst.setLastestId(++rowCount);
				emst.setApprovalDate((String)row.get("LTEM_APPR_DATE"));
				emst.setCorpCode    ((String)row.get("LTEM_CORP_CODE"));
				emst.setCostGubn    ((String)row.get("LTEM_COST_GUBN"));
				emst.setPartNo      ((String)row.get("LTEM_PART_NO"  ));
				emst.setEoNo        ((String)row.get("LTEM_EONO"     ));
				emst.setCumtNo     ((Integer)row.get("LTEM_CUMT_NO"  ));
				emst.setInitCman    ((String)row.get("LTEM_INIT_CMAN"));

				emst.setUpdateDate(DateUtil.getToday() + " " + DateUtil.getTime());
				
				session.save(emst);
				if(rowCount % 50 == 0) {
					session.flush();
					session.clear();
				}
			}
			
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		logger.debug("E: " + DateUtil.getTime());

		return rowCount;
	}

	@Override
	public Integer getSize() {
		Integer size = null;
		Session session = HibernateUtilBatch.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List<?> subParts = session.createQuery("FROM LatestEndPart").list();
			size = subParts.size();
			
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return size;
	}

	@Override
	public void emptyTable() {
		Session session = HibernateUtilBatch.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Query query = session.createQuery(" DELETE FROM LatestEndPart ");
			query.executeUpdate();
			
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}
