package br.edu.fa7.bdnc.dao;

import javax.persistence.EntityManager;

import br.edu.fa7.bdnc.model.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {

	public FuncionarioDao(EntityManager entityManager) {
		super(entityManager);
	}

}
