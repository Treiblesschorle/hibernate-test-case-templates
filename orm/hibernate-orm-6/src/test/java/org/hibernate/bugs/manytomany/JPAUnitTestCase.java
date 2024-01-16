package org.hibernate.bugs.manytomany;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
	public void testManyToMany() {
		String externalId = "someId";

		String queryTemplate =
			"SELECT e1 " +
			"FROM Entity1 e1 " +
			"INNER JOIN e1.relatedEntities2 as relatedEntities2 " +
			"WHERE relatedEntities2.naturalId = :naturalId";

		runInTransaction(() -> {
			var e2 = new Entity2(externalId);
			em.persist(e2);

			var e1 = new Entity1();
			e1.setRelatedEntities2(Set.of(e2));
			em.persist(e1);
		});

		runInTransaction(() -> {
			em.createQuery(queryTemplate, Entity1.class).setParameter("naturalId", externalId)
				.getSingleResult();
		});
	}

	private void runInTransaction(final Runnable runner) {
		em.getTransaction().begin();
		runner.run();
		em.getTransaction().commit();
	}
}
