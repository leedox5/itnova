package com.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRDCHSU")
public class Chsu {

	private ChsuPK chsuPK;
	private Double price;
	private String currCode;
	private String matlDate;
	private String userID;
	private String deptID;
	private String sendDate;
	private String insDate;
	private String insTime;
	private String procYn;
	private String stat;
	
	public Chsu() {
		
	}
	
	public Chsu(ChsuPK chsuPK) {
		this.chsuPK = chsuPK;
	}

	@EmbeddedId
	public ChsuPK getChsuPK() {
		return chsuPK;
	}

	public void setChsuPK(ChsuPK chsuPK) {
		this.chsuPK = chsuPK;
	}

	@Column(name="CHSU_PRICE")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name="CHSU_CURR_CD")
	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	@Column(name="CHSU_DATE")
	public String getMatlDate() {
		return matlDate;
	}

	public void setMatlDate(String matlDate) {
		this.matlDate = matlDate;
	}

	@Column(name="CHSU_USER_ID")
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Column(name="CHSU_DEPT_CD")
	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	@Column(name="CHSU_SEND_DATE")
	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	@Column(name="CHSU_INS_DATE")
	public String getInsDate() {
		return this.insDate;
	}

	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}

	@Column(name="CHSU_INS_TIME")
	public String getInsTime() {
		return this.insTime;
	}

	public void setInsTime(String insTime) {
		this.insTime = insTime;
	}

	@Column(name="CHSU_PROC_YN")
	public String getProcYn() {
		return procYn;
	}

	public void setProcYn(String procYn) {
		this.procYn = procYn;
	}

	@Column(name="CHSU_STAT")
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
