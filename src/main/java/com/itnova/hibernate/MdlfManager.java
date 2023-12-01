package com.itnova.hibernate;

import com.itnova.entities.Mdlf;
import com.itnova.entities.MdlfPK;

public interface MdlfManager {

	Mdlf findMdlfByID(MdlfPK pk);

}
