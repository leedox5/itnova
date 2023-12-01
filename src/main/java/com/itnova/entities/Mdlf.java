package com.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRBMDLF")
public class Mdlf {

	private MdlfPK mdlfPK;
	
	private Integer moldLife;

	public Mdlf() {
		
	}

	@EmbeddedId
	public MdlfPK getMdlfPK() {
		return mdlfPK;
	}

	public void setMdlfPK(MdlfPK mdlfPK) {
		this.mdlfPK = mdlfPK;
	}

	@Column(name="MDLF_MOLD_LIFE")
	public Integer getMoldLife() {
		return moldLife;
	}

	public void setMoldLife(Integer moldLife) {
		this.moldLife = moldLife;
	}
	
}
