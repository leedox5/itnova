package com.itnova.dao;

import java.util.List;

import org.hibernate.Query;

import com.itnova.entities.Chms;
import com.itnova.entities.ChmsPK;
import com.itnova.hibernate.HibernateUtil;


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
