package br.edu.fa7.bdnc.dao;

import javax.persistence.EntityManager;

public class GenericDao<T> {
	protected EntityManager entityManager;
	
	public GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}
	
	public void commit() {
		entityManager.getTransaction().commit();
	}
	
	public void persist(T object) {
		entityManager.persist(object);
	}
}
