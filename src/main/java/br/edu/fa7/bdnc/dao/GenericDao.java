package br.edu.fa7.bdnc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public void merge(T objeto) {
		entityManager.merge(objeto);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<?> c) {
		String sql = "SELECT o FROM " + c.getSimpleName() + " o";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}
	
	public void removeAll(Class<?> clazz) {
		String delete = "DELETE FROM " + clazz.getSimpleName();
		Query query = entityManager.createQuery(delete);
		query.executeUpdate();
	}
}
