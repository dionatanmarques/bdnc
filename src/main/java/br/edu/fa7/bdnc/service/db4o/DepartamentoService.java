package br.edu.fa7.bdnc.service.db4o;

import java.util.Date;

import br.edu.fa7.bdnc.dao.db4o.DepartamentoDAO;
import br.edu.fa7.bdnc.model.db4o.Departamento;


public class DepartamentoService {
	
	private DepartamentoDAO departamentoDao;
	
	public DepartamentoService(DepartamentoDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}
	
	public void insert(int totalInserts) {

		Departamento departamento;
		long inicio = System.currentTimeMillis();
		
		departamentoDao.beginTransaction();
		System.out.println("Iniciando inserção de " + totalInserts + " departamentos" + new Date());
		
		for(int i = 0; i< totalInserts; i++) {
			departamento = new Departamento(i);
			departamento.setNome("Departamento - " + i);
		
			departamentoDao.persist(departamento);
			System.out.println("Inserido departamento " + i);
		}
		
		departamentoDao.commit();		
		System.out.println("Inserção de " + totalInserts + " departamentos finalizada " + new Date());
		
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");
		
	}
	
	public void find(){
		long inicio = System.currentTimeMillis();
		departamentoDao.beginTransaction();
		System.out.println("Iniciando consulta  departamentos " + new Date());
		Departamento departamento = departamentoDao.find(9);
		System.out.println("Total de Funcionario "+departamento.getFunctionarios().size());
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de processamento: " + (fim - inicio) + " milissegundos");
	}

}
