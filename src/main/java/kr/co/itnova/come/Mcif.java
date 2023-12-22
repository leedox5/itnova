package kr.co.itnova.come;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "PFRBMCIF")
public class Mcif {

    @EmbeddedId
    private McifPK mcifPK;

    @Column( name = "MCIF_DRCT_COST")
    private Double mcifDrctCost;

    public Mcif() {

    }

    public Mcif(McifPK mcifPK) {
        this.mcifPK = mcifPK;
    }



    public Double getMcifDrctCost() {
        return mcifDrctCost;
    }

    public void setMcifDrctCost(Double mcifDrctCost) {
        this.mcifDrctCost = mcifDrctCost;
    }
}
