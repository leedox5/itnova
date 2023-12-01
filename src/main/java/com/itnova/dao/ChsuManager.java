package com.itnova.dao;

import java.util.List;

import com.itnova.entities.Chsu;

public interface ChsuManager {

	void saveNewChsu(Chsu chsu);

	Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode);

	List<Chsu> loadFinished();

}
