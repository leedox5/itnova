package com.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class SimePK implements Serializable{
	private static final long serialVersionUID = 1L;
	private String corpCode;
	private String mngeNo;
	private String costGubn;
	private String partNo;
	private String eoNo;
	private Integer cumtNo;
	private String linkGubn;
	private Integer adjtSeq0;
	
	public SimePK() {}
	
	@Column(name="SIME_CORP_CODE")
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	@Column(name="SIME_MNGE_NO")
	public String getMngeNo() {
		return mngeNo;
	}
	public void setMngeNo(String mngeNo) {
		this.mngeNo = mngeNo;
	}
	@Column(name="SIME_COST_GUBN")
	public String getCostGubn() {
		return costGubn;
	}
	public void setCostGubn(String costGubn) {
		this.costGubn = costGubn;
	}
	@Column(name="SIME_PART_NO")
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	@Column(name="SIME_EONO")
	public String getEoNo() {
		return eoNo;
	}
	public void setEoNo(String eoNo) {
		this.eoNo = eoNo;
	}
	@Column(name="SIME_CUMT_NO")
	public Integer getCumtNo() {
		return cumtNo;
	}
	public void setCumtNo(Integer cumtNo) {
		this.cumtNo = cumtNo;
	}
	@Column(name="SIME_LINK_GUBN")
	public String getLinkGubn() {
		return linkGubn;
	}
	public void setLinkGubn(String linkGubn) {
		this.linkGubn = linkGubn;
	}
	@Column(name="SIME_ADJT_SEQ0")
	public Integer getAdjtSeq0() {
		return adjtSeq0;
	}
	public void setAdjtSeq0(Integer adjtSeq0) {
		this.adjtSeq0 = adjtSeq0;
	}
}
