package com.itnova.dao;

import java.util.List;

import com.itnova.entities.Chms;
import com.itnova.entities.ChmsPK;

public interface ChmsDAO extends GenericDAO<Chms, ChmsPK> {

	List<Chms> findAllAlive(Class<Chms> class1);
}
