package br.edu.fa7.bdnc.service;

import br.edu.fa7.bdnc.dao.DepartamentoDao;

public class DepartamentoService {

	private DepartamentoDao departamentoDao;
	
	public DepartamentoService(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

}
