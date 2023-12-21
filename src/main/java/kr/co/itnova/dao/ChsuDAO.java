package kr.co.itnova.dao;

import kr.co.itnova.entities.Chsu;
import kr.co.itnova.entities.ChsuPK;

public interface ChsuDAO extends GenericDAO<Chsu, ChsuPK>{

	Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode);

}
