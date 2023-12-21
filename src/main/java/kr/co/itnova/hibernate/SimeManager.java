package kr.co.itnova.hibernate;

import java.util.List;

import kr.co.itnova.entities.Sime;
import kr.co.itnova.entities.SimePart;
import kr.co.itnova.entities.Simm;

public interface SimeManager {

	List<Sime> loadAllByMnge(String mngeNo);

	List<SimePart> loadAllByMngeNo(String string);

	void runProc70(final String partNo, final Simm simm);

	List<SimePart> loadAllByVendCode(String mngeNo, String vendCode);

	SimePart find(String string, List<SimePart> simeList);

}
