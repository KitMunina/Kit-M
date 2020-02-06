package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		//parametri connessione al database
		String url = "jdbc:postgresql://localhost/kitm";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","170599");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, props);
			String query = "Select * from articolo a join magazzino m on (a.idmagazzino=m.idmagazzino) join amministratore am on (a.piva=am.piva)";
			
			PreparedStatement s = connection.prepareStatement(query);
			
			ResultSet rs = s.executeQuery();
			ArrayList<Amministratore> admlist = new ArrayList<Amministratore>();
			ArrayList<Magazzino> maglist = new ArrayList<Magazzino>();
			
			//lettura del ResultSet
			while(rs.next()) {
				Amministratore admin = new Amministratore();
				admin.setPiva(rs.getString(14));
				admin.setNome(rs.getString(15));
				admin.setCognome(rs.getString(16));
				
				Magazzino mag = new Magazzino();
				mag.setIdmagazzino(rs.getString(11));
				mag.setIndirizzo(rs.getString(12));
				mag.setCitta(rs.getString(13));

				if(admlist.contains(admin) && maglist.contains(mag)) {
					Amministratore adcurr = admlist.get(admlist.indexOf(admin));
					Magazzino magcurr = maglist.get(maglist.indexOf(mag));
					Articolo art =  new Articolo();
					
					art.setIdarticolo(rs.getString(1));
					art.setNome(rs.getString(2));
					art.setDescrizione(rs.getString(3));
					art.setPrezzo(rs.getFloat(4));
					art.setTaglia(rs.getString(5));
					art.setColore(rs.getString(6));
					art.setReparto(rs.getString(7));
					art.setQuantita(rs.getInt(8));
					
					adcurr.getArticoli().add(art);
					magcurr.getArticoli().add(art);
				}
			}
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
		}
	}
}
