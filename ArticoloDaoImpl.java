package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ArticoloDaoImpl implements ArticoloDao {
	private Connection connection;
	
	public ArticoloDaoImpl() {
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
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,quantita from articolo";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
			
			while (rs.next()) {
				Articolo a = new Articolo();
				
				a.setIdarticolo(rs.getString(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setQuantita(rs.getInt(8));
				
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
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,quantita from articolo where reparto='Maschile'";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
			
			while (rs.next()) {
				Articolo a = new Articolo();
				
				a.setIdarticolo(rs.getString(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setQuantita(rs.getInt(8));
				
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
			String query ="select idarticolo,nome,descrizione,prezzo,taglia,colore,reparto,quantita from articolo where descrizione in('Tshirt','Camicia')";
			ResultSet rs = s.executeQuery(query);
			List<Articolo> articoli = new ArrayList<Articolo>();
		
			while (rs.next()) {
				Articolo a = new Articolo();
			
				a.setIdarticolo(rs.getString(1));
				a.setNome(rs.getString(2));
				a.setDescrizione(rs.getString(3));
				a.setPrezzo(rs.getFloat(4));
				a.setTaglia(rs.getString(5));
				a.setColore(rs.getString(6));
				a.setReparto(rs.getString(7));
				a.setQuantita(rs.getInt(8));
			
				articoli.add(a);
			}
		
			return articoli;
		
		}catch (Exception e) {
			System.err.println("Errore SQL");
			return null;
		}
	}
}
