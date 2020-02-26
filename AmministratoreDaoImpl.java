package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AmministratoreDaoImpl implements AmministratoreDao {
	private Connection connection;
	
	public AmministratoreDaoImpl() { //connessione al database con credenziali di accesso
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "jdbc:postgresql://localhost/kitm";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","170599");
		connection = null;
		
		try {
			connection = DriverManager.getConnection(url, props);			
		}catch (Exception e) {
			System.err.println("Errore di connessione");
		}
	}
	
	@Override
	public List<Amministratore> getAdmin() {
		try {
			Statement s = connection.createStatement();
			String query ="select * from amministratore";
			ResultSet rs = s.executeQuery(query);
			List<Amministratore> amministratori = new ArrayList<Amministratore>();
			Controller c = new Controller();
			
			while (rs.next()) {
				Amministratore a = new Amministratore();
				
				a.setPiva(rs.getString(1));
				a.setNome(rs.getString(2));
				a.setCognome(rs.getString(3));
				a.setArticoli(c.getAllArticoli());

				amministratori.add(a);
			}
			
			return amministratori;
			
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
}
