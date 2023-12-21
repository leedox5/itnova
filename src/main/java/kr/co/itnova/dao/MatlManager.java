package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Matl;
import kr.co.itnova.entities.MatlPK;

public interface MatlManager {
	Matl findMatlByID(MatlPK matlPK);

	List<Matl> loadByCode(MatlPK matlPK);
}
