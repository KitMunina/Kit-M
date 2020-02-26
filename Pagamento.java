package main;

public class Pagamento {
	private int idpagamento;
	private float totale;
	private Cliente cliente;
	private int idordine;
	
	public int getIdpagamento() {
		return idpagamento;
	}
	
	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}
	
	public float getTotale() {
		return totale;
	}
	
	public void setTotale(float totale) {
		this.totale = totale;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdordine() {
		return idordine;
	}

	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
}
