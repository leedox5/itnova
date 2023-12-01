package com.itnova.hibernate;

import java.util.List;

import com.itnova.entities.Sime;
import com.itnova.entities.SimePart;
import com.itnova.entities.Simm;

public interface SimeManager {

	List<Sime> loadAllByMnge(String mngeNo);

	List<SimePart> loadAllByMngeNo(String string);

	void runProc70(final String partNo, final Simm simm);

	List<SimePart> loadAllByVendCode(String mngeNo, String vendCode);

	SimePart find(String string, List<SimePart> simeList);

}
