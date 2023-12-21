package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Chms;
import kr.co.itnova.entities.ChmsPK;

public interface ChmsDAO extends GenericDAO<Chms, ChmsPK> {

	List<Chms> findAllAlive(Class<Chms> class1);
}
