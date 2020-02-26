package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ArticoloDaoImpl implements ArticoloDao {
	private Connection connection;
	
	public ArticoloDaoImpl() { //connessione al database con credenziali di accesso
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
	public List<Articolo> getAllArticoli() {
		try {
			Statement s = connection.createStatement();
			String query ="select a.idarticolo,a.nome,a.descrizione,a.prezzo,a.taglia,a.colore,a.reparto,a.disponibilita from articolo a join magazzino m on (a.idmagazzino=m.idmagazzino) order by a.idarticolo";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
			
			while (rs.next()) {
				Articolo a = new Articolo();
				
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
				
				articoli.add(a);
			}
			
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllMale() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where reparto='Maschile'";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
			
			while (rs.next()) {
				Articolo a = new Articolo();
				
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
				
				articoli.add(a);
			}
			
			return articoli;
			
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllFemale() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where reparto='Femminile'";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
			
			while (rs.next()) {
				Articolo a = new Articolo();
				
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
				
				articoli.add(a);
			}
			
			return articoli;
			
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllUpperParts() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione in('Tshirt','Felpa','Camicia')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllLowerParts() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione in('Gonna','Pantalone')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllShoes() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione in('Scarpe','Calzini')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllOvercoats() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione in('Cappotto','Giubbino')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllUnderwears() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione='Intimo'";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public List<Articolo> getAllAccessories() {
		try {
			Statement s = connection.createStatement();
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,disponibilita from articolo where descrizione in ('Borsa','Cappello','Orologio')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setDisponibilita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
	
	@Override
	public boolean insertArticolo(Articolo artnuovo) {
		try {
			String query = "insert into articolo (nome,descrizione,prezzo,taglia,colore,reparto,disponibilita,piva,idmagazzino) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement s = connection.prepareStatement(query);
			
			s.clearParameters();
			s.setString(1, artnuovo.getNome());
			s.setString(2, artnuovo.getDescrizione());
			s.setFloat(3, artnuovo.getPrezzo());
			s.setString(4, artnuovo.getTaglia());
			s.setString(5, artnuovo.getColore());
			s.setString(6, artnuovo.getReparto());
			s.setInt(7, artnuovo.getDisponibilita());
			s.setString(8, "123456789");
			s.setInt(9, 1);
			
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
	public boolean updateArticolo(Articolo artedit) {
		try {
			String query ="update articolo set prezzo=?, taglia=?, colore=?, disponibilita=? where idarticolo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.clearParameters();
			ps.setFloat(1, artedit.getPrezzo());
			ps.setString(2, artedit.getTaglia());
			ps.setString(3, artedit.getColore());
			ps.setInt(4, artedit.getDisponibilita());
			ps.setInt(5, artedit.getIdarticolo());
			
			ps.executeUpdate();
			
			return true;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return false;
		}
	}
	
	@Override
	public boolean deleteArticolo(Articolo artremove) {
		try {
			String query ="delete from articolo where idarticolo=?";
			PreparedStatement ps = connection.prepareStatement(query);
		
			ps.clearParameters();
			ps.setInt(1, artremove.getIdarticolo());
			
			ps.executeUpdate();
			
			return true;
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return false;
		}
	}
	
	@Override
	public void updateQuantityItemAfterPayment(int idarticolo, int quantita) {
		try {
			String query ="update articolo set disponibilita=disponibilita-? where idarticolo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.clearParameters();
			ps.setInt(1, quantita);
			ps.setInt(2, idarticolo);
			
			ps.executeUpdate();
		}catch (Exception e) {
			System.err.println("Errore SQL");
		}
	}
}