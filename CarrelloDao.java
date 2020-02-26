package main;

import java.util.List;

public interface CarrelloDao {
	public Carrello getCarrelloOf(Cliente cliente);
	public List<ContenutoCarrello> getCartContent(int idcarrello);
	public boolean addToCart(int idarticolo, int idcarrello, int quantita);
	public boolean removeFromCart(int idart);
	public void svuotaCarrello(Carrello c);
	public void updateCartContent(int idart, int qta);
	public void insertCart(Cliente cliente);
}
