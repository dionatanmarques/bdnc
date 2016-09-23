package br.edu.fa7.bdnc.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final String UNIDADE_RELACIONAL = "default";

	public static EntityManager createRelationalEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(UNIDADE_RELACIONAL);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;		
	}

}
