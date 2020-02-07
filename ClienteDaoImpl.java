package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ClienteDaoImpl implements ClienteDao {
	private Connection connection;
	
	public ClienteDaoImpl() {
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
	public List<Cliente> getCustomers() {
		try {
			Statement s = connection.createStatement();
			String query ="select * from cliente";
			ResultSet rs = s.executeQuery(query);
			List<Cliente> clienti = new ArrayList<Cliente>();
			
			while (rs.next()) {
				Cliente c = new Cliente();
				
				c.setIdcliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getString(5));
				c.setIndirizzo(rs.getString(6));
				c.setCitta(rs.getString(7));
				
				clienti.add(c);
			}
			
			return clienti;
			
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
}
