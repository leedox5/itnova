package kr.co.itnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatlPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private String corpCode;
	private String stndGubn;
	private String matlCode;
	private String applFrdt;
	private String matlGubn;
	
	public MatlPK() {
		
	}
	
	public MatlPK(String corpCode, String stndGubn, String matlCode, String applFrdt, String matlGubn) {
		this.corpCode = corpCode;
		this.stndGubn = stndGubn;
		this.matlCode = matlCode;
		this.applFrdt = applFrdt;
		this.matlGubn = matlGubn;
	}

	@Column(name="MATL_CORP_CODE")
	public String getCorpCode() {
		return this.corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	@Column(name="MATL_STND_GUBN")
	public String getStndGubn() {
		return this.stndGubn;
	}

	public void setStndGubn(String stndGubn) {
		this.stndGubn = stndGubn;
	}

	@Column(name="MATL_CODE")
	public String getMatlCode() {
		return this.matlCode;
	}

	public void setMatlCode(String matlCode) {
		this.matlCode = matlCode;
	}

	@Column(name="MATL_APPL_FRDT")
	public String getApplFrdt() {
		return this.applFrdt;
	}

	public void setApplFrdt(String applFrdt) {
		this.applFrdt = applFrdt;
	}

	@Column(name="MATL_GUBN")
	public String getMatlGubn() {
		return this.matlGubn;
	}

	public void setMatlGubn(String matlGubn) {
		this.matlGubn = matlGubn;
	}
	
	
}
