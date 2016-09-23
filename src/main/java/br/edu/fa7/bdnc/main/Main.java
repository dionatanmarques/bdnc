package br.edu.fa7.bdnc.main;

import javax.persistence.EntityManager;

import br.edu.fa7.bdnc.dao.DepartamentoDao;
import br.edu.fa7.bdnc.dao.FuncionarioDao;
import br.edu.fa7.bdnc.service.DepartamentoService;
import br.edu.fa7.bdnc.service.FuncionarioService;
import br.edu.fa7.bdnc.utils.EntityManagerUtil;



public class Main {
	private static DepartamentoService departamentoService;
	private static FuncionarioService funcionarioService;
	
	
	private static void getServices(EntityManager entityManager) {
		Main.departamentoService = new DepartamentoService(new DepartamentoDao(entityManager));
		Main.funcionarioService = new FuncionarioService(new FuncionarioDao(entityManager));
	}
	
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtil.createRelationalEntityManager();
		getServices(entityManager);
		
		departamentoService.insert(8);
		funcionarioService.insert(100000);
		funcionarioService.findAll();
		funcionarioService.updateDepartamento();
	}
}
