package br.edu.fa7.bdnc.service;

import java.util.Date;

import br.edu.fa7.bdnc.dao.DepartamentoDao;
import br.edu.fa7.bdnc.model.Departamento;

public class DepartamentoService {

	private DepartamentoDao departamentoDao;
	
	public DepartamentoService(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

	public void insert(int totalInserts) {

		Departamento departamento;
		long inicio = System.currentTimeMillis();
		
		departamentoDao.beginTransaction();
		System.out.println("Iniciando inserção de " + totalInserts + " departamentos" + new Date());
		
		for(int i = 0; i< totalInserts; i++) {
			departamento = new Departamento();
			departamento.setNome("Departamento - " + i);
		
			departamentoDao.persist(departamento);
			System.out.println("Inserido departamento " + i);
		}
		
		departamentoDao.commit();		
		System.out.println("Inserção de " + totalInserts + " departamentos finalizada " + new Date());
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");
		
	}

}
