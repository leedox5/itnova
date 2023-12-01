package com.itnova.dao;

import java.util.List;

import org.hibernate.Query;

import com.itnova.entities.Matl;
import com.itnova.entities.MatlPK;
import com.itnova.hibernate.HibernateUtil;

public class MatlDAOImpl extends GenericDAOImpl<Matl, MatlPK> implements MatlDAO {

	@Override
	public List<Matl> findByCode(MatlPK matlPK) {
		List<Matl> matls = null;
		String sql = "FROM Matl t WHERE t.matlPK.corpCode = :corpCode AND t.matlPK.stndGubn = :stndGubn AND t.matlPK.matlCode = :matlCode AND t.matlPK.applFrdt > :applFrdt AND t.matlPK.matlGubn = :matlGubn";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("corpCode", matlPK.getCorpCode())
				.setParameter("stndGubn", matlPK.getStndGubn())
				.setParameter("matlCode", matlPK.getMatlCode())
				.setParameter("applFrdt", matlPK.getApplFrdt())
				.setParameter("matlGubn", matlPK.getMatlGubn());
		
		matls = findMany(query);
		
		return matls;
	}
}
