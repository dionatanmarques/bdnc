package br.edu.fa7.bdnc.utils.db4o;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DB4OConnection {
	
	final static String DB4OFILENAME = System.getProperty("user.home")
            + "/teste.db4o";
	
	private static ObjectContainer db;
	
	
	private static void createConnection(){
        db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), DB4OFILENAME);
	}
	
	public static ObjectContainer getDb(){
		if(db != null){
			db.close();
		}
		createConnection();
		return db;
	}
	
	public static void deleteDb(){
		new File(DB4OFILENAME).delete();
	}

}
