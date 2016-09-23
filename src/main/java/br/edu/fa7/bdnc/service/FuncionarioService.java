package br.edu.fa7.bdnc.service;

import java.util.Date;
import java.util.List;

import br.edu.fa7.bdnc.dao.FuncionarioDao;
import br.edu.fa7.bdnc.model.Departamento;
import br.edu.fa7.bdnc.model.Funcionario;

public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	public void insert(int totalInserts) {
		Funcionario funcionario;
		Departamento departamento = new Departamento(1l);
		long inicio = System.currentTimeMillis();
		
		funcionarioDao.beginTransaction();
		System.out.println("Iniciando inserção de " + totalInserts + " funcionarios" + new Date());
		
		for(int i = 0; i< totalInserts; i++) {
			funcionario = new Funcionario();
			funcionario.setNome("Funcionario - " + i);
			funcionario.setDepartamento(departamento);
			funcionarioDao.persist(funcionario);
			System.out.println("Inserido funcionario " + i);
		}
		
		funcionarioDao.commit();		
		System.out.println("Inserção de " + totalInserts + " finalizada " + new Date());
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");
	}
	
	public void findAll() {

		System.out.println("Inicialdo FULL TABLE SCAN da tabela FUNCIONARIO");
		long inicio = System.currentTimeMillis();

		List<Funcionario> funcionarios = funcionarioDao.findAll(Funcionario.class);
		long fim = System.currentTimeMillis();
		
		System.out.println(funcionarios.size() + " funcionario lidos em " + (fim - inicio) + " milissegundos");
	}

	public void updateDepartamento() {
		List<Funcionario> funcionarios = funcionarioDao.findAll(Funcionario.class);
		Departamento departamento = new Departamento(2l);
	

		
		funcionarioDao.beginTransaction();
		
		System.out.println("Inicialdo FULL TABLE SCAN da tabela FUNCIONARIO");
		long inicio = System.currentTimeMillis();
		
		for (Funcionario funcionario : funcionarios) {
			funcionario.setDepartamento(departamento);
			funcionarioDao.merge(funcionario);
		}

		funcionarioDao.commit();

		long fim = System.currentTimeMillis();
		System.out.println(funcionarios.size() + " funcionario atualizados em " + (fim - inicio) + " milissegundos");
		
	}

}
