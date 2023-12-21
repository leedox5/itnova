package kr.co.itnova.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RMSFLE.PFRBMATL")
public class Matl {

	private MatlPK matlPK;
	private Double matlPric;
	
	public Matl() {
		
	}
	
	public Matl(MatlPK matlPK) {
		this.matlPK = matlPK;
	}

	@EmbeddedId
	public MatlPK getMatlPK() {
		return this.matlPK;
	}

	public void setMatlPK(MatlPK matlPK) {
		this.matlPK = matlPK;
	}

	@Column(name="MATL_PRIC")
	public Double getMatlPric() {
		return this.matlPric;
	}

	public void setMatlPric(Double matlPric) {
		this.matlPric = matlPric;
	}
}
