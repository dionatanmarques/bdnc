package br.edu.fa7.bdnc.dao.db4o;

import br.edu.fa7.bdnc.model.db4o.Departamento;
import br.edu.fa7.bdnc.utils.db4o.DB4OConnection;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;



public class DepartamentoDAO {
	
	private ObjectContainer db;
	
	public void persist(Departamento departamento){
		db.store(departamento);
	}
	
	public void commit(){
		this.db.commit();
		this.db.close();
	}
	
	public void beginTransaction(){
		db = DB4OConnection.getDb();
	}
	
	public Departamento find(int id){
		ObjectSet<Departamento> result = db.queryByExample(new Departamento(id));
		Departamento found = (Departamento) result.next();
		return found;
	}

}
