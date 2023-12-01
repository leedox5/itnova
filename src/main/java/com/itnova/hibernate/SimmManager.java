package com.itnova.hibernate;

import com.itnova.entities.Simm;
import com.itnova.entities.SimmPK;

public interface SimmManager {
	Simm findSimmByID(SimmPK pk);
}
