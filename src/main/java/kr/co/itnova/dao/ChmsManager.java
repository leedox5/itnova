package kr.co.itnova.dao;

import java.util.List;

import kr.co.itnova.entities.Chms;
import kr.co.itnova.entities.ChmsPK;


public interface ChmsManager {
	void saveNewChms(Chms chms) throws Exception;

	Chms findChmsByID(ChmsPK chmsPk);

	List<Chms> loadAllChms();
	
	List<Chms> loadAllByDel();
}
