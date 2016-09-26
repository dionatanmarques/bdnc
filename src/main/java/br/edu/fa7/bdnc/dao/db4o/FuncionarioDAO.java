package br.edu.fa7.bdnc.dao.db4o;

import java.util.ArrayList;
import java.util.List;

import br.edu.fa7.bdnc.model.db4o.Funcionario;
import br.edu.fa7.bdnc.utils.db4o.DB4OConnection;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class FuncionarioDAO {
	
	private ObjectContainer db;
	
	public void persist(Funcionario funcionario){
		db.store(funcionario);
	}
	
	public void delete(Funcionario funcionario){
		db.delete(funcionario);
	}
	
	public void commit(){
		this.db.commit();
		this.db.close();
	}
	
	public void beginTransaction(){
		db = DB4OConnection.getDb();
	}

	public List<Funcionario> findAll() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		ObjectSet<Funcionario> result = db.queryByExample(Funcionario.class);
		for (Object o : result) {
	        Funcionario funcionario = (Funcionario) o;
	        funcionarios.add(funcionario);
	    }
		return funcionarios;
	}

}
