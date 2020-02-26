package main;

public interface PagamentoDao {
	public boolean insertPayment(float totale, Cliente cliente, Ordine ordine);
	public float getTotalFromPayment(Ordine ordine);
}
