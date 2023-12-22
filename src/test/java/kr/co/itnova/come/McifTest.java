package kr.co.itnova.come;

import kr.co.itnova.hibernate.HibernateUtilLocal;
import org.hibernate.Session;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class McifTest {

    @Test
    public void saveTest() {
        McifPK mcifPK = new McifPK("1000", "M", "ALL", "MLAM", "AL-COAT-MC1", "20231101");
        Mcif mcif = new Mcif(mcifPK);
        mcif.setMcifDrctCost(48358.0d);

        McifDAO mcifDAO = new McifDAOImpl();
        mcifDAO.save(mcif);
    }

    @Test
    public void shouldReturnRightValue() {
        McifDAO mcifDAO = new McifDAOImpl(HibernateUtilLocal.getSessionFactory().openSession());

        Mcif mcif = mcifDAO.findByID(Mcif.class, new McifPK("1000", "M", "ALL", "MLAM", "AL-COAT-MC1", "20231101"));

        assertThat(mcif.getMcifDrctCost()).isEqualTo(48358.0d);
    }
}
