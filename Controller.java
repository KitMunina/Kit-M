package main;

import java.util.List;

public class Controller {
	private ArticoloDao artdao = new ArticoloDaoImpl();
	private AmministratoreDao admdao = new AmministratoreDaoImpl();
	private ClienteDao cldao = new ClienteDaoImpl();
	
	public List<Articolo> getAllArticoli() { //Lista di tutti gli articoli presenti in magazzino
		return artdao.getAllArticoli();
	}
	
	public List<Articolo> getAllMale() { //Lista di tutti gli articoli maschili
		return artdao.getAllMale();
	}
	
	public List<Articolo> getAllUpperParts() { //Lista di tutti gli articoli "parti superiori"
		return artdao.getAllUpperParts();
	}
	
	public List<Articolo> getAllLowerParts() { //lista di tutti gli articoli "parti inferiori"
		return artdao.getAllLowerParts();
	}
	
	public List<Articolo> getAllShoes() { //lista di tutti gli articoli "scarpe e calzini"
		return artdao.getAllShoes();
	}
	
	public List<Articolo> getAllOvercoats() { //lista di tutti gli articoli "soprabiti"
		return artdao.getAllOvercoats();
	}
	
	public List<Articolo> getAllUnderwears() { //lista di tutti gli articoli "intimo"
		return artdao.getAllUnderwears();
	}
	
	public List<Articolo> getAllAccessories() { //lista di tutti gli articoli "accessori"
		return artdao.getAllAccessories();
	}
	
	public boolean insertArticolo(Articolo artnuovo) { //inserisce un nuovo articolo nel magazzino
		return artdao.insertArticolo(artnuovo);
	}
	
	public boolean updateArticolo(Articolo artedit) { //aggiornamento di un articolo nel magazzino
		return artdao.updateArticolo(artedit);
	}
	
	public boolean deleteArticolo(Articolo artremove) { //rimuove un articolo dal magazzino
		return artdao.deleteArticolo(artremove);
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
			Homepage h = new Homepage();
			h.loggedc = true;
			h.username.setText("Ciao, "+c.get(i).getNome());
			h.setVisible(true);
			h.setLocationRelativeTo(null);
			
			AccessoEseguito ac = new AccessoEseguito();
			ac.setLocationRelativeTo(null);
			ac.ciao.setText("Ciao "+c.get(i).getNome()+", bentornato in Kit&M!");
			ac.setVisible(true);
			return true;
		}
		else {
			Errore e = new Errore();
			e.setLocationRelativeTo(null);
			e.setVisible(true);
			return false;
		}
	}
	
	public boolean checkAdminLogin(String piva) { //verifica le credenziali di accesso al pannello di controllo dell'amministratore
		List<Amministratore> a = admdao.getAdmin();
		int i = 0;
		
		while ((i<a.size()) && (!a.get(i).getPiva().equals(piva))) {
			i++;
		}
		
		if(i<a.size()) {
			PaginaAmministratore pa = new PaginaAmministratore();
			pa.setLocationRelativeTo(null);
			pa.setVisible(true);

			AccessoEseguito ac = new AccessoEseguito();
			ac.setLocationRelativeTo(null);
			ac.ciao.setText(a.get(i).getNome()+", hai l'accesso al pannello di controllo");
			ac.setVisible(true);
			
			return true;
		}
		else {
			Errore e = new Errore();
			e.setLocationRelativeTo(null);
			e.setVisible(true);
			return false;
		}
	}
	
	public Articolo findArticolo(String idarticolo) { //effettua la ricerca di un articolo per id
		List<Articolo> a = artdao.getAllArticoli();
		int i = 0;
		
		while ((i<a.size()) && (!a.get(i).getIdarticolo().equals(idarticolo))) {
			i++;
		}
		
		if(i<a.size()) {
			return a.get(i);
		}
		else {
			Errore e = new Errore();
			e.setLocationRelativeTo(null);
			e.setVisible(true);
			return null;
		}
	}
}
