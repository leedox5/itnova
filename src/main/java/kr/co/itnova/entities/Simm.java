package kr.co.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRDSIMM")
public class Simm {
	
	private SimmPK simmPK;
	
	private String simuCode;
	private String startTime02;
	private String endTime02;
	private String initCman;
	
	public Simm() {
		
	}
	
	public Simm(SimmPK pk) {
		this.setSimmPK(pk);
	}

	@EmbeddedId
	public SimmPK getSimmPK() {
		return simmPK;
	}

	public void setSimmPK(SimmPK simmPK) {
		this.simmPK = simmPK;
	}

	@Column(name="SIMM_SIMU_CODE")
	public String getSimuCode() {
		return simuCode;
	}
	public void setSimuCode(String simuCode) {
		this.simuCode = simuCode;
	}
	@Column(name="SIMM_STRT_TM02")
	public String getStartTime02() {
		return startTime02;
	}
	public void setStartTime02(String startTime02) {
		this.startTime02 = startTime02;
	}

	@Column(name="SIMM_END0_TM02")
	public String getEndTime02() {
		return endTime02;
	}

	public void setEndTime02(String endTime02) {
		this.endTime02 = endTime02;
	}

	@Column(name="SIMM_INIT_CMAN")
	public String getInitCman() {
		return initCman;
	}

	public void setInitCman(String initCman) {
		this.initCman = initCman;
	}
}
