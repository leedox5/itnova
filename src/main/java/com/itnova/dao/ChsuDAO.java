package com.itnova.dao;

import com.itnova.entities.Chsu;
import com.itnova.entities.ChsuPK;

public interface ChsuDAO extends GenericDAO<Chsu, ChsuPK>{

	Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode);

}
