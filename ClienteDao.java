package main;

import java.util.List;

public interface ClienteDao {
	public List<Cliente> getCustomers(); //restituisce tutti i clienti registrati
	public boolean checkLogin(String email, String password);
	public Cliente getUser(String email, String password);
	public boolean insertUser(String nome, String cognome, String email, String password, String indirizzo, String citta);
	public boolean updateCustomer(String password, String indirizzo, String citta);
}
