package kr.co.itnova.hibernate;

import org.hibernate.Session;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HibernateUtilLocalTest {
    @Test
    public void getFactoryTest() {
        try (Session session = HibernateUtilLocal.getSessionFactory().openSession()) {
            assertThat(session).isNotNull();
        }
    }
}