package com.itnova.dao;

import java.util.List;

import com.itnova.entities.Chms;
import com.itnova.entities.ChmsPK;


public interface ChmsManager {
	void saveNewChms(Chms chms) throws Exception;

	Chms findChmsByID(ChmsPK chmsPk);

	List<Chms> loadAllChms();
	
	List<Chms> loadAllByDel();
}
