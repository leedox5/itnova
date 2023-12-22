package kr.co.itnova.dao;

import kr.co.itnova.entities.Simm;
import kr.co.itnova.entities.SimmPK;
import org.hibernate.Session;

public class SimmDAOImpl extends GenericDAOImpl<Simm, SimmPK> implements SimmDAO {

    public SimmDAOImpl(Session session) {
        super(session);
    }

    public SimmDAOImpl() {

    }
}
