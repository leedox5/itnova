package kr.co.itnova.come;

import kr.co.itnova.dao.GenericDAOImpl;
import org.hibernate.Session;

public class McifDAOImpl extends GenericDAOImpl<Mcif, McifPK> implements McifDAO {
    public McifDAOImpl(Session session) {
        super(session);
    }

    public McifDAOImpl() {

    }
}
