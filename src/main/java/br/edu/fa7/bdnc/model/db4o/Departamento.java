package br.edu.fa7.bdnc.model.db4o;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	private int id;
	
	private String nome;
	
	private List<Funcionario> functionarios;

	public Departamento(int id) {
		this.id = id;
	}
	
	public Departamento() {
	}

	public List<Funcionario> getFunctionarios() {
		if(functionarios == null){
			functionarios = new ArrayList<Funcionario>();
		}
		return functionarios;
	}

	public void setFunctionarios(List<Funcionario> functionarios) {
		this.functionarios = functionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
