package main;

import java.util.List;

public interface OrdineDao {
	public boolean insertOrder();
	public Ordine getOrder();
	public void insertOrderDetails(int idart, int idord, int quantita, float prezzo);
}
