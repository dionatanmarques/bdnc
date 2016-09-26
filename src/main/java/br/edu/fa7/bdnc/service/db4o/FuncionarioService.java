package br.edu.fa7.bdnc.service.db4o;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.edu.fa7.bdnc.dao.db4o.FuncionarioDAO;
import br.edu.fa7.bdnc.model.db4o.Departamento;
import br.edu.fa7.bdnc.model.db4o.Funcionario;


public class FuncionarioService {
	
	private FuncionarioDAO funcionarioDao;
	
	public FuncionarioService(FuncionarioDAO funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}
	
	public void insert(int totalInserts) {
		Funcionario funcionario;
		Departamento departamento = new Departamento(9);
		departamento.setNome("DP - 9");
		long inicio = System.currentTimeMillis();
		
		funcionarioDao.beginTransaction();
		System.out.println("Iniciando inserção de " + totalInserts + " funcionarios " + new Date());
		
		for(int i = 0; i< totalInserts; i++) {
			funcionario = new Funcionario();
			funcionario.setId(i);
			funcionario.setNome("Funcionario - " + i);
			funcionario.setDepartamento(departamento);
			funcionarioDao.persist(funcionario);
			//System.out.println("Inserido funcionario " + i);
		}
		
		funcionarioDao.commit();		
		System.out.println("Inserção de " + totalInserts + " finalizada " + new Date());
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");
	}

	public void findAll() {
		funcionarioDao.beginTransaction();
		System.out.println("Inicialdo FULL TABLE SCAN da tabela FUNCIONARIO");
		long inicio = System.currentTimeMillis();

		List<Funcionario> funcionarios = funcionarioDao.findAll();
		long fim = System.currentTimeMillis();
		
		System.out.println(funcionarios.size() + " funcionario lidos em " + (fim - inicio) + " milissegundos");
		System.out.println(funcionarios.get(0).getDepartamento().getNome());
	}
	
	public void updateDepartamento() {
		funcionarioDao.beginTransaction();
		List<Funcionario> funcionarios = funcionarioDao.findAll();
		Departamento departamento = new Departamento(8);
		departamento.setNome("DP - 8");
		System.out.println("Inicialdo FULL TABLE SCAN da tabela FUNCIONARIO");
		long inicio = System.currentTimeMillis();
		
		for (Funcionario funcionario : funcionarios) {
			funcionario.setDepartamento(departamento);
			funcionarioDao.persist(funcionario);
		}

		funcionarioDao.commit();

		long fim = System.currentTimeMillis();
		System.out.println(funcionarios.size() + " funcionario atualizados em " + (fim - inicio) + " milissegundos");
		
	}
	
	public void deleteAll() {
		funcionarioDao.beginTransaction();
		System.out.println("Inicialdo remoção da todos registro na tabela FUNCIONARIO");
		long inicio = System.currentTimeMillis();

		List<Funcionario> funcionarios = funcionarioDao.findAll();
		for (Funcionario funcionario : funcionarios) {
			funcionarioDao.delete(funcionario);
		}
		
		funcionarioDao.commit();
		long fim = System.currentTimeMillis();
		
		System.out.println(funcionarios.size() + " funcionario removidos em " + (fim - inicio) + " milissegundos");
		System.out.println(funcionarios.get(0).getDepartamento().getNome());
	}
}
