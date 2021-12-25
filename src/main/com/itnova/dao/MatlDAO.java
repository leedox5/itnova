package com.itnova.dao;

import java.util.List;

import com.itnova.entities.Matl;
import com.itnova.entities.MatlPK;

public interface MatlDAO extends GenericDAO<Matl, MatlPK>{

	List<Matl> findByCode(MatlPK matlPK);
	
}
