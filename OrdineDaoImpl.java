package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class OrdineDaoImpl implements OrdineDao {
private Connection connection;
	
	public OrdineDaoImpl() { //connessione al database con credenziali di accesso
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
	public boolean insertOrder() {
		try {
			String query = "insert into ordine (data) values (current_date)";
			PreparedStatement s = connection.prepareStatement(query);

			s.clearParameters();
			
			s.executeUpdate();
			
			return true;
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Ordine getOrder() {
		try {
			Statement s = connection.createStatement();
			String query ="select * from ordine where idordine=(select max(idordine) from ordine)";
			ResultSet rs = s.executeQuery(query);
			Ordine ordine = new Ordine();
			
			while(rs.next()) {
				ordine.setIdordine(rs.getInt(1));
				ordine.setData(rs.getDate(2).toString());
			}
			
			return ordine;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public void insertOrderDetails(int idart, int idord, int quantita, float prezzo) {
		try {
			String query = "insert into dettagliordine values(?,?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);

			s.clearParameters();
			s.setInt(1, idart);
			s.setInt(2, idord);
			s.setInt(3, quantita);
			s.setFloat(4, prezzo);
			
			s.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
}
