package br.edu.fa7.bdnc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento extends Model {

	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Funcionario> functionarios;

	public List<Funcionario> getFunctionarios() {
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
