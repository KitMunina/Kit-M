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
	public Carrello getCarrelloOf(Cliente cliente) {
		try {
			Statement s = connection.createStatement();
			String query ="select * from carrello where idcliente="+cliente.getIdcliente();
			ResultSet rs = s.executeQuery(query);
			Carrello c = new Carrello();
			
			while(rs.next()) {
				c.setIdcarrello(rs.getInt(1));
				c.setNarticoli(rs.getInt(2));
				c.setTotale(rs.getFloat(3));
				c.setCliente(cliente);
			}
			
			return c;
		}catch (Exception e) {
			System.err.println("Errore SQL getCarrello");
			return null;
		}
	}
	
	@Override
	public List<ContenutoCarrello> getCartContent(int idcarrello) {
		try {
			Statement s = connection.createStatement();
			String query ="select * from contenutocarrello where idcarrello='"+idcarrello+"'";
			ResultSet rs = s.executeQuery(query);
			List<ContenutoCarrello> contenuto = new ArrayList<ContenutoCarrello>();
			
			while(rs.next()) {
				ContenutoCarrello cc = new ContenutoCarrello();
				cc.setIdarticolo(rs.getInt(1));
				cc.setIdcarrello(rs.getInt(2));
				cc.setQuantita(rs.getInt(3));
				
				contenuto.add(cc);
			}
			
			return contenuto;
		}catch (Exception e) {
			System.err.println("Errore SQL getContenuto");
			return null;
		}
	}
	
	@Override
	public boolean addToCart(int idarticolo, int idcarrello, int quantita) {
		try {
			String query = "insert into contenutocarrello values (?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setInt(1, idarticolo);
			s.setInt(2, idcarrello);
			s.setInt(3, quantita);
			
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
	public boolean removeFromCart(int idart) {
		try {
			String query = "delete from contenutocarrello where (idarticolo=?) and (idcarrello=?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setInt(1, idart);
			s.setInt(2, Homepage.carrello.getIdcarrello());
			
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
	public void svuotaCarrello(Carrello c) {
		try {
			String query = "delete from contenutocarrello where (idcarrello=?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setInt(1, c.getIdcarrello());
			
			s.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateCartContent(int idart, int qta) {
		try {
			String query = "update contenutocarrello  set quantita=? where (idcarrello=?) and (idarticolo=?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setInt(1, qta);
			s.setInt(2, Homepage.carrello.getIdcarrello());
			s.setInt(3, idart);
			
			s.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertCart(Cliente cliente) {
		try {
			String query = "insert into carrello (narticoli,totale,idcliente) values (?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setInt(1, 0);
			s.setInt(2, 0);
			s.setInt(3, cliente.getIdcliente());
			
			s.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
}
