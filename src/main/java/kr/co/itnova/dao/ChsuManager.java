package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Chsu;

public interface ChsuManager {

	void saveNewChsu(Chsu chsu);

	Integer getMaxSeq(String corpCode, String vendCode, String partNo, String pvendCode);

	List<Chsu> loadFinished();

}
