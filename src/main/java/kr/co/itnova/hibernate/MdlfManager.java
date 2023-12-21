package kr.co.itnova.hibernate;

import kr.co.itnova.entities.Mdlf;
import kr.co.itnova.entities.MdlfPK;

public interface MdlfManager {

	Mdlf findMdlfByID(MdlfPK pk);

}
