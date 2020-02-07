package main;

import java.util.List;

public class Controller {
	private ArticoloDao artdao = new ArticoloDaoImpl();;
	private ClienteDao cldao = new ClienteDaoImpl();
	
	public List<Articolo> getAllArticoli() { //Lista di tutti gli articoli presenti in magazzino
		List<Articolo> a = artdao.getAllArticoli();
		return a;
	}
	
	public List<Articolo> getAllMale() { //Lista di tutti gli articoli maschili
		List<Articolo> a = artdao.getAllMale();
		return a;
	}
	
	public List<Articolo> getAllUpperParts() { //Lista di tutti gli articoli "parti superiori"
		List<Articolo> a = artdao.getAllUpperParts();
		return a;
	}
	
	public void insertArticolo(Articolo artnuovo) { //inserisce un nuovo articolo nel database
		artdao.insertArticolo(artnuovo);
	}
	
	public void updateArticolo(Articolo artedit) { //aggiornamento di un articolo
		artdao.updateArticolo(artedit);
	}
	
	public Articolo findArticolo(String idarticolo) { //ricerca per id di un articolo nella lista
		List<Articolo> a = artdao.getAllArticoli();
		int i = 0;
		
		while ((i<a.size()) && (!a.get(i).getIdarticolo().equals(idarticolo))){
			i++;
		}
		
		if(i<a.size()) {
			return a.get(i);
		}
		else {
			return null;
		}
	}
	
	public List<Cliente> getAllCustomers() { //restituisce tutti gli utenti registrati
		List<Cliente> c = cldao.getCustomers();
		return c;
	}
	
	public boolean checkUserLogin(String email, String password) { //verifica le credenziali di accesso del cliente
		List<Cliente> c = cldao.getCustomers();
		int i = 0;
		
		while ((i<c.size()) && (!c.get(i).getEmail().equals(email) && !c.get(i).getPassword().equals(password))) {
			i++;
		}
		
		if(i<c.size()) {
			AccessoEseguito ok = new AccessoEseguito();
			ok.setVisible(true);
			
			return true;
		}
		else {
			Errore e = new Errore();
			e.setVisible(true);
		
			return false;
		}
	}
}
