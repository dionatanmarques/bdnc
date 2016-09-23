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
		
		System.out.println("Iniciando inserção de departamentos");
		departamentoService.insert(8);
		
		System.out.println("Iniciando inserção de funcionarios");
		funcionarioService.insert(100000);
		
		System.out.println("Iniciando leitura de funcionarios e departamentos");
		funcionarioService.findAll();
		
		System.out.println("Iniciando atualizaççao de funcionarios");
		funcionarioService.updateDepartamento();
	}
}
