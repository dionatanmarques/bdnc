package br.edu.fa7.bdnc.dao;

import javax.persistence.EntityManager;

import br.edu.fa7.bdnc.model.Departamento;

public class DepartamentoDao extends GenericDao<Departamento>{

	public DepartamentoDao(EntityManager entityManager) {
		super(entityManager);
	}

}
