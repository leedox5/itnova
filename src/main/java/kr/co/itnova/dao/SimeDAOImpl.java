package kr.co.itnova.dao;

import kr.co.itnova.entities.Sime;
import kr.co.itnova.entities.SimePK;
import org.hibernate.Session;

public class SimeDAOImpl extends GenericDAOImpl<Sime, SimePK> implements SimeDAO {

    public SimeDAOImpl(Session session) {
        super(session);
    }

    public SimeDAOImpl() {

    }
}
