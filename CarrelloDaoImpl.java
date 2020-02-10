package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CarrelloDaoImpl implements CarrelloDao {
	private Connection connection;
	
	public CarrelloDaoImpl(){
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
	public void addToCarrello(Articolo a) {
		try {
			String query = "insert into carrello values (?,?,?,?,?,?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setString(1, a.getIdarticolo());
			s.setString(2, a.getNome());
			s.setString(3, a.getDescrizione());
			s.setFloat(4, a.getPrezzo());
			s.setString(5, a.getTaglia());
			s.setString(6, a.getColore());
			s.setString(7, a.getReparto());
			s.setInt(8, a.getQuantita());
		
			s.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
