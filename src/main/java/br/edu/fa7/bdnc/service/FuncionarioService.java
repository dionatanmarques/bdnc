package br.edu.fa7.bdnc.service;

import java.util.Date;

import br.edu.fa7.bdnc.dao.FuncionarioDao;
import br.edu.fa7.bdnc.model.Funcionario;

public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	
	public FuncionarioService(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	public void insert(int totalInserts) {
		Funcionario funcionario;
		long inicio = System.currentTimeMillis();
		
		funcionarioDao.beginTransaction();
		System.out.println("Iniciando inserção de " + totalInserts + " funcionarios" + new Date());
		
		for(int i = 0; i< totalInserts; i++) {
			funcionario = new Funcionario();
			funcionario.setNome("Funcionario - " + i);
			funcionarioDao.persist(funcionario);
			System.out.println("Inserido funcionario " + i);
		}
		
		funcionarioDao.commit();		
		System.out.println("Inserção de " + totalInserts + " finalizada " + new Date());
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");

	}

}
