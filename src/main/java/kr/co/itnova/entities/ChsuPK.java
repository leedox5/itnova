package kr.co.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChsuPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String corpCode;
	private String vendCode;
	private String partNo;
	private String pvendCode;
	private Integer seq;

	public ChsuPK(String corpCode, String vendCode, String partNo, String pvendCode, Integer seq) {
		this.corpCode = corpCode;
		this.vendCode = vendCode;
		this.partNo = partNo;
		this.pvendCode = pvendCode;
		this.seq = seq;
	}
	
	public ChsuPK() {
		
	}

	@Column(name="CHSU_CORP_CODE")
	public String getCorpCode() {
		return this.corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	@Column(name="CHSU_VEND_CD")
	public String getVendCode() {
		return this.vendCode;
	}

	public void setVendCode(String vendCode) {
		this.vendCode = vendCode;
	}

	@Column(name="CHSU_PART_NO")
	public String getPartNo() {
		return this.partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	@Column(name="CHSU_PVEND_CD")
	public String getPvendCode() {
		return this.pvendCode;
	}

	public void setPvendCode(String pvendCode) {
		this.pvendCode = pvendCode;
	}

	@Column(name="CHSU_SEQ")
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}
