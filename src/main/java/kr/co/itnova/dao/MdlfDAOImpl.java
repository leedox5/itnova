package kr.co.itnova.dao;

import kr.co.itnova.entities.Mdlf;
import kr.co.itnova.entities.MdlfPK;
import org.hibernate.Session;

public class MdlfDAOImpl extends GenericDAOImpl<Mdlf, MdlfPK> implements MdlfDAO {
    public MdlfDAOImpl(Session session) {
        super(session);
    }

    public MdlfDAOImpl() {

    }
}
