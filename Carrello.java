package main;

import java.util.List;

public class Carrello {
	private int idcarrello;
	private int narticoli;
	private float totale;
	private Cliente cliente;

	public int getIdcarrello() {
		return idcarrello;
	}
	
	public void setIdcarrello(int idcarrello) {
		this.idcarrello = idcarrello;
	}
	
	public int getNarticoli() {
		return narticoli;
	}
	
	public void setNarticoli(int narticoli) {
		this.narticoli = narticoli;
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
}
