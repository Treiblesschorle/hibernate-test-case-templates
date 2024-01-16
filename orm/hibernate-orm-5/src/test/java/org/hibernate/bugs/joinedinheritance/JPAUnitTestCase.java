package org.hibernate.bugs.joinedinheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
        em = entityManagerFactory.createEntityManager();
    }

    @After
    public void destroy() {
        em.clear();
        entityManagerFactory.close();
    }

    @Test
    public void testJoinedInheritance() throws Exception {
        String externalId = "someId";

        String queryTemplate =
              "SELECT iv "
            + "FROM Item i "
            + "JOIN i.itemVersions iv "
            + "WHERE i.externalId = :externalId";

        runInTransaction(() -> {
            Item item = new Item(externalId);
            em.persist(item);
            ItemVersion itemVersion = new ItemVersionA(item, "foo bar");
            em.persist(itemVersion);
        });

        runInTransaction(() -> {
            em.createQuery(queryTemplate, ItemVersion.class).setParameter("externalId", externalId)
                .getSingleResult();
        });
    }

    private void runInTransaction(final Runnable runner) {
        em.getTransaction().begin();
        runner.run();
        em.getTransaction().commit();
    }
}
