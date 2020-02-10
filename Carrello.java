package main;

import java.util.ArrayList;

public class Carrello {
	private String idcarrello;
	private int narticoli;
	private float totale;
	private String cliente;
	private ArrayList<Articolo> articoli;
	
	public String getIdcarrello() {
		return idcarrello;
	}
	
	public void setIdcarrello(String idcarrello) {
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
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Articolo> getArticoli() {
		return articoli;
	}
	
	public void setArticoli(ArrayList<Articolo> articoli) {
		this.articoli = articoli;
	}
}
