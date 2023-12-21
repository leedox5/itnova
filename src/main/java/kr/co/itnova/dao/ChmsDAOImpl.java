package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Chms;
import kr.co.itnova.entities.ChmsPK;
import kr.co.itnova.hibernate.HibernateUtil;
import org.hibernate.Query;


public class ChmsDAOImpl extends GenericDAOImpl<Chms, ChmsPK> implements ChmsDAO {

	@Override
	public List<Chms> findAllAlive(Class<Chms> class1) {
		List<Chms> chmss = null;
		String sql = "FROM Chms t WHERE t.deleDate = ''  ";
		Query query = HibernateUtil.getSession().createQuery(sql);
		
		chmss = findMany(query);
		
		return chmss;
	}
}
