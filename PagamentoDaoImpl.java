package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PagamentoDaoImpl implements PagamentoDao {
	private Connection connection;
	
	public PagamentoDaoImpl() { //connessione al database con credenziali di accesso
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
	public boolean insertPayment(float totale, Cliente cliente, Ordine ordine) {
		try {
			String query = "insert into pagamento (totale,idcliente,idordine) values (?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setFloat(1, totale);
			s.setInt(2, cliente.getIdcliente());
			s.setInt(3, ordine.getIdordine());
			
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
	public float getTotalFromPayment(Ordine ordine) {
		try {
			Statement s = connection.createStatement();
			String query ="select p.totale from pagamento p join ordine o on p.idordine=o.idordine where o.idordine="+ordine.getIdordine();
			ResultSet rs = s.executeQuery(query);
			
			return rs.getFloat(1);
		}catch (Exception e) {
			System.err.println("Errore SQL gettotale");
			return 0;
		}
	}
}
