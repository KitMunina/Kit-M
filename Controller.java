package main;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private ArticoloDao artdao = new ArticoloDaoImpl();
	private AmministratoreDao admdao = new AmministratoreDaoImpl();
	private ClienteDao cldao = new ClienteDaoImpl();
	private CarrelloDao cardao = new CarrelloDaoImpl();
	private PagamentoDao pagdao = new PagamentoDaoImpl();
	private OrdineDao orderdao = new OrdineDaoImpl();
	
	public List<Articolo> getAllArticoli() { //Lista di tutti gli articoli presenti in magazzino
		return artdao.getAllArticoli();
	}
	
	public List<Articolo> getAllMale() { //Lista di tutti gli articoli maschili
		return artdao.getAllMale();
	}
	
	public List<Articolo> getAllFemale() { //lista di tutti gli articoli femminili
		return artdao.getAllFemale();
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
		return cldao.checkLogin(email, password);
	}
	
	public Cliente getUser(String email, String password) { //ritorna il cliente con determinata email e password
		return cldao.getUser(email, password);
	}
	
	public boolean insertUser(String nome, String cognome, String email, String password, String indirizzo, String citta) { //registrazione di un nuovo utente
		return cldao.insertUser(nome, cognome, email, password, indirizzo, citta);
	}
	
	public void insertCart(String email, String password) {
		Cliente cliente = getUser(email, password);
		cardao.insertCart(cliente);
	}
	
	public Carrello getCarrelloOf(Cliente cliente) { //ritorna il carrello di un determinato cliente
		return cardao.getCarrelloOf(cliente);
	}
	
	public List<ContenutoCarrello> getCartContent(int idcarrello) { //restituisce il contenuto del carrello
		return cardao.getCartContent(idcarrello);		
	}
	
	public boolean removeFromCart(int idart) { //rimuove un articolo dal carrello
		return cardao.removeFromCart(idart);
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
			AccessoEseguito.ciao.setText(a.get(i).getNome()+", hai l'accesso al pannello di controllo");
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
	
	public Articolo findArticolo(int idarticolo) { //effettua la ricerca di un articolo per id
		List<Articolo> a = artdao.getAllArticoli();
		int i = 0;
		
		while ((i<a.size()) && (a.get(i).getIdarticolo() != idarticolo)) {
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
	
	public boolean addToCart(int idarticolo, int idcarrello, int quantita) { //aggiunge un articolo nel carrello con la rispettiva quantitá
		return cardao.addToCart(idarticolo, idcarrello, quantita);
	}
	
	public boolean insertOrderPayment(Cliente cliente, float totale) { //inserisce il pagamento nel database
		return pagdao.insertPayment(totale, cliente, orderdao.getOrder());
	}
	
	public boolean insertOrder() { //inserisce l'ordine nel database
		return orderdao.insertOrder();
	}
	
	public void insertOrderDetails() { //inserimento dei dettagli dell'ordine
		List<ContenutoCarrello> cc = getCartContent(Homepage.carrello.getIdcarrello());
		
		for(int i = 0; i < cc.size(); i++) {
			orderdao.insertOrderDetails(cc.get(i).getIdarticolo(), orderdao.getOrder().getIdordine(), cc.get(i).getQuantita(), findArticolo(cc.get(i).getIdarticolo()).getPrezzo());
		}
	}
	
	public void updateQuantityItemAfterPayment() { //aggiorna la quantita in magazzino dopo un acquisto
		List<ContenutoCarrello> cc = getCartContent(Homepage.carrello.getIdcarrello());
		
		for(int i = 0; i < cc.size(); i++) {
			artdao.updateQuantityItemAfterPayment(cc.get(i).getIdarticolo(), cc.get(i).getQuantita());
		}
	}
	
	public float getTotalFromPayment(Ordine ordine) { //restituisce il totale di un ordine
		return pagdao.getTotalFromPayment(ordine);
	}
	
	public boolean updateCustomer(String password, String indirizzo, String citta) { //aggiorna le informazioni di un cliente
		return cldao.updateCustomer(password, indirizzo, citta);
	}
	
	public void svuotaCarrello(Carrello c) { //svuota il carrello
		cardao.svuotaCarrello(c);
	}
	
	public void updateCartContent(int idart, int qta) { //aggiorna la quantita di un articolo nel carrello
		cardao.updateCartContent(idart, qta);
	}
}
