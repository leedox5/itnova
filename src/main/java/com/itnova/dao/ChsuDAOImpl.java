package com.itnova.dao;

import java.util.List;

import org.hibernate.Query;

import com.itnova.entities.Chsu;
import com.itnova.entities.ChsuPK;
import com.itnova.hibernate.HibernateUtil;

public class ChsuDAOImpl extends GenericDAOImpl<Chsu, ChsuPK> implements ChsuDAO {

	@Override
	public Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode) {
		String sql = "SELECT max(t.chsuPK.seq) FROM Chsu t WHERE t.chsuPK.corpCode = :corpCode AND t.chsuPK.vendCode = :vendCode AND t.chsuPK.partNo = :partNo AND t.chsuPK.pvendCode = :pvendCode";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("corpCode", corpCode)
				.setParameter("vendCode", vendCode)
				.setParameter("partNo", partNo)
				.setParameter("pvendCode", pvendCode);
		List<?> list = query.list();
		return (Integer)list.get(0) == null ? 0 : (Integer)list.get(0);
	}

}
