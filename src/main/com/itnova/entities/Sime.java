package com.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRDSIME")
public class Sime {
	private SimePK simePK;
	private String cretGubn;
	private String causLkcd;
	private String vendCode;
	
	@EmbeddedId
	public SimePK getSimePK() {
		return simePK;
	}
	public void setSimePK(SimePK simePK) {
		this.simePK = simePK;
	}
	@Column(name="SIME_CRET_GUBN")
	public String getCretGubn() {
		return cretGubn;
	}
	public void setCretGubn(String cretGubn) {
		this.cretGubn = cretGubn;
	}
	
	@Column(name="SIME_CAUS_LKCD")
	public String getCausLkcd() {
		return causLkcd;
	}
	public void setCausLkcd(String causLkcd) {
		this.causLkcd = causLkcd;
	}
	
	@Column(name="SIME_VEND_CODE")
	public String getVendCode() {
		return vendCode;
	}
	public void setVendCode(String vendCode) {
		this.vendCode = vendCode;
	}

}
