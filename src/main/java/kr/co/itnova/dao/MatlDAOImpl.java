package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Matl;
import kr.co.itnova.entities.MatlPK;
import kr.co.itnova.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class MatlDAOImpl extends GenericDAOImpl<Matl, MatlPK> implements MatlDAO {

	public MatlDAOImpl(Session session) {
		super(session);
	}

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
