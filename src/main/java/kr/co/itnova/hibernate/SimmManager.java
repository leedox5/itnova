package kr.co.itnova.hibernate;

import kr.co.itnova.entities.Simm;
import kr.co.itnova.entities.SimmPK;

public interface SimmManager {
	Simm findSimmByID(SimmPK pk);
}
