package com.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SimmPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private String corpCode;
	private String mngeNo;

	public SimmPK() { }
	
	public SimmPK(String corpCode, String mngeNo) {
		this.corpCode = corpCode;
		this.mngeNo = mngeNo;
	}

	@Column(name="SIMM_CORP_CODE")
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	@Column(name="SIMM_MNGE_NO")
	public String getMngeNo() {
		return mngeNo;
	}

	public void setMngeNo(String mngeNo) {
		this.mngeNo = mngeNo;
	}

}
