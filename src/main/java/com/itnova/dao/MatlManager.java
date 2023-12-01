package com.itnova.dao;

import java.util.List;

import com.itnova.entities.Matl;
import com.itnova.entities.MatlPK;

public interface MatlManager {
	Matl findMatlByID(MatlPK matlPK);

	List<Matl> loadByCode(MatlPK matlPK);
}
