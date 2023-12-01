package com.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MdlfPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String corpCode;
	private String stndGubn;
	private String moldGubn;
	private String mddeGubn;
	private String applDate;
	
	public MdlfPK() {}
	
	public MdlfPK(String corpCode, String stndGubn, String moldGubn, String mddeGubn, String applDate) {
		this.corpCode = corpCode;
		this.stndGubn = stndGubn;
		this.moldGubn = moldGubn;
		this.mddeGubn = mddeGubn;
		this.applDate = applDate;
	}

	@Column(name="MDLF_CORP_CODE")
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	@Column(name="MDLF_STND_GUBN")
	public String getStndGubn() {
		return stndGubn;
	}

	public void setStndGubn(String stndGubn) {
		this.stndGubn = stndGubn;
	}

	@Column(name="MDLF_MOLD_GUBN")
	public String getMoldGubn() {
		return moldGubn;
	}

	public void setMoldGubn(String moldGubn) {
		this.moldGubn = moldGubn;
	}

	@Column(name="MDLF_MDDE_GUBN")
	public String getMddeGubn() {
		return mddeGubn;
	}

	public void setMddeGubn(String mddeGubn) {
		this.mddeGubn = mddeGubn;
	}

	@Column(name="MDLF_APPL_DATE")
	public String getApplDate() {
		return applDate;
	}

	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}
	
}
