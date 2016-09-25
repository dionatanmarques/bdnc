package br.edu.fa7.bdnc.main.db4o;

import br.edu.fa7.bdnc.dao.db4o.DepartamentoDAO;
import br.edu.fa7.bdnc.dao.db4o.FuncionarioDAO;
import br.edu.fa7.bdnc.service.db4o.DepartamentoService;
import br.edu.fa7.bdnc.service.db4o.FuncionarioService;
import br.edu.fa7.bdnc.utils.db4o.DB4OConnection;



public class Main {
	
	private static DepartamentoService departamentoService;
	private static FuncionarioService funcionarioService;
	
	private static void getServices() {
		Main.departamentoService = new DepartamentoService(new DepartamentoDAO());
		Main.funcionarioService = new FuncionarioService(new FuncionarioDAO());
	}
	
	public static void main(String[] args) {
		DB4OConnection.deleteDb();
		getServices();
		System.out.println("Inicialdo Dos Teste de Preformace");
		long inicio = System.currentTimeMillis();
		
		System.out.println("Iniciando inserção de departamentos");
		departamentoService.insert(8);
		
		System.out.println("Iniciando inserção de funcionarios");
		funcionarioService.insert(100000);
		
		System.out.println("Iniciando leitura de funcionarios e departamentos");
		funcionarioService.findAll();
		
		System.out.println("Iniciando atualizaççao de funcionarios");
		funcionarioService.updateDepartamento();
		
		long fim = System.currentTimeMillis();
		System.out.println("Finalizados os teste em " + (fim - inicio) + " milissegundos");
	}

}
