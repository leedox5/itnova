package com.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChmsPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private String corpCode;
	private String vendCode;
	private String partNo;
	private String pvendCode;
	
	public ChmsPK() {
		
	}
	
	public ChmsPK(String corpCode, String vendCode, String partNo, String pvendCode) {
		this.corpCode = corpCode;
		this.vendCode = vendCode;
		this.partNo = partNo;
		this.pvendCode = pvendCode;
	}

	@Column(name="CHMS_CORP_CODE")
	public String getCorpCode() {
		return this.corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	@Column(name="CHMS_VEND_CD")
	public String getVendCode() {
		return this.vendCode;
	}

	public void setVendCode(String vendCode) {
		this.vendCode = vendCode;
	}

	@Column(name="CHMS_PART_NO")
	public String getPartNo() {
		return this.partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	@Column(name="CHMS_PVEND_CD")
	public String getPvendCode() {
		return this.pvendCode;
	}

	public void setPvendCode(String pvendCode) {
		this.pvendCode = pvendCode;
	}
}
