package com.itnova.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRMLTEM")
public class LatestEndPart {
	
	private int lastestId;
	private String approvalDate;
	private String corpCode;
	private String costGubn;
	private String partNo;
	private String eoNo;
	private long cumtNo;
	private String initCman;
	private String updateDate;
	
	@Id
	@Column(name="LTEM_IDTY")
	public int getLastestId() {
		return this.lastestId;
	}
	public void setLastestId(int lastestId) {
		this.lastestId = lastestId;
	}
	
	@Column(name="LTEM_APPR_DATE", length=20)
	public String getApprovalDate() {
		return this.approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	@Column(name="LTEM_CORP_CODE", length=4)
	public String getCorpCode() {
		return this.corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	@Column(name="LTEM_COST_GUBN", length=2)
	public String getCostGubn() {
		return this.costGubn;
	}
	public void setCostGubn(String costGubn) {
		this.costGubn = costGubn;
	}
	@Column(name="LTEM_PART_NO", length=21)
	public String getPartNo() {
		return this.partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	@Column(name="LTEM_EONO", length=10)
	public String getEoNo() {
		return eoNo;
	}
	public void setEoNo(String eoNo) {
		this.eoNo = eoNo;
	}
	@Column(name="LTEM_CUMT_NO")
	public long getCumtNo() {
		return this.cumtNo;
	}
	public void setCumtNo(long cumtNo) {
		this.cumtNo = cumtNo;
	}
	@Column(name="LTEM_INIT_CMAN", length=8)
	public String getInitCman() {
		return this.initCman;
	}
	public void setInitCman(String initCman) {
		this.initCman = initCman;
	}
	@Column(name="LTEM_UPDT_DATE", length=20)
	public String getUpdateDate() {
		return this.updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
