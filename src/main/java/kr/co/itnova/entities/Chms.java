package kr.co.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="RMSFLE.PFRDCHMS")
public class Chms {

	private ChmsPK chmsPK;
	private String partName;
	private String applDate;
	private String matlStnd;
	private String matlGubn;
	private String matlCode;
	private String matlAppl;
	private String initDate;
	private String initCman;
	private String updtDate;
	private String updtCman;
	private String deleDate;
	private String deleCman;
	private String initCnfm;
	private String procStat;
	
	public Chms() {
		
	}
	
	public Chms(ChmsPK chmsPk, String applDate) {
		this.chmsPK = chmsPk;
		this.applDate = applDate;
	}

	@EmbeddedId
	public ChmsPK getChsuPK() {
		return this.chmsPK;
	}

	public void setChsuPK(ChmsPK chmsPK) {
		this.chmsPK = chmsPK;
	}

	@Column(name="CHMS_PART_NAME")
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@Column(name="CHMS_APPL_DATE")
	public String getApplDate() {
		return this.applDate;
	}

	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}

	
	@Column(name="CHMS_MATL_STND")
	public String getMatlStnd() {
		return this.matlStnd;
	}

	public void setMatlStnd(String matlStnd) {
		this.matlStnd = matlStnd;
	}

	@Column(name="CHMS_MATL_GUBN")
	public String getMatlGubn() {
		return this.matlGubn;
	}
	
	public void setMatlGubn(String matlGubn) {
		this.matlGubn = matlGubn;
	}

	@Column(name="CHMS_MATL_CODE")
	public String getMatlCode() {
		return this.matlCode;
	}

	public void setMatlCode(String matlCode) {
		this.matlCode = matlCode;
	}

	@Column(name="CHMS_MATL_APPL")
	public String getMatlAppl() {
		return this.matlAppl;
	}

	public void setMatlAppl(String matlAppl) {
		this.matlAppl = matlAppl;
	}

	@Column(name="CHMS_INIT_DATE")
	public String getInitDate() {
		return this.initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	@Column(name="CHMS_INIT_CMAN")
	public String getInitCman() {
		return this.initCman;
	}

	public void setInitCman(String initCman) {
		this.initCman = initCman;
	}

	@Column(name="CHMS_UPDT_DATE")
	public String getUpdtDate() {
		return this.updtDate;
	}

	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}

	@Column(name="CHMS_UPDT_CMAN")
	public String getUpdtCman() {
		return this.updtCman;
	}

	public void setUpdtCman(String updtCman) {
		this.updtCman = updtCman;
	}

	@Column(name="CHMS_DELE_DATE")
	public String getDeleDate() {
		return this.deleDate;
	}

	public void setDeleDate(String deleDate) {
		this.deleDate = deleDate;
	}

	@Column(name="CHMS_DELE_CMAN")
	public String getDeleCman() {
		return this.deleCman;
	}

	public void setDeleCman(String deleCman) {
		this.deleCman = deleCman;
	}

	@Column(name="CHMS_INIT_CNFM")
	public String getInitCnfm() {
		return initCnfm;
	}

	public void setInitCnfm(String initCnfm) {
		this.initCnfm = initCnfm;
	}

	@Column(name="CHMS_PROC_STAT")
	public String getProcStat() {
		return procStat;
	}

	public void setProcStat(String procStat) {
		this.procStat = procStat;
	}


	
}
