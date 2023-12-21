package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Matl;
import kr.co.itnova.entities.MatlPK;

public interface MatlDAO extends GenericDAO<Matl, MatlPK>{

	List<Matl> findByCode(MatlPK matlPK);
	
}
