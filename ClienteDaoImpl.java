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
				
				c.setIdcliente(rs.getInt(1));
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
	
	@Override
	public boolean checkLogin(String email, String password) {
		try {
			Statement s = connection.createStatement();
			String query ="select * from cliente where email = '"+email+"' and password = '"+password+"'";
			ResultSet rs = s.executeQuery(query);
			
			return rs.next();
			
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return false;
		}
	}
	
	@Override
	public Cliente getUser(String email, String password) {
		try {
			Statement s = connection.createStatement();
			String query ="select * from cliente where email='"+email+"' and password='"+password+"'";
			ResultSet rs = s.executeQuery(query);
			Cliente c = new Cliente();
			
			while(rs.next()) {
				c.setIdcliente(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getString(5));
				c.setIndirizzo(rs.getString(6));
				c.setCitta(rs.getString(7));
			}
			return c;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	
	@Override
	public boolean insertUser(String nome, String cognome, String email, String password, String indirizzo, String citta) {
		try {
			String query = "insert into cliente (nome,cognome,email,password,indirizzo,citta) values (?,?,?,?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setString(1, nome);
			s.setString(2, cognome);
			s.setString(3, email);
			s.setString(4, password);
			s.setString(5, indirizzo);
			s.setString(6, citta);
			
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
	public boolean updateCustomer(String password, String indirizzo, String citta) {
		try {
			String query = "update cliente set password=?, indirizzo=?, citta=? where idcliente=?";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setString(1, password);
			s.setString(2, indirizzo);
			s.setString(3,  citta);
			s.setInt(4, Homepage.cliente.getIdcliente());
			
			s.executeUpdate();
			
			return true;
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
			return false;
		}
	}
}
