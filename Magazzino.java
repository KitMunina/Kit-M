package main;

import java.util.ArrayList;

public class Magazzino {
	private int idmagazzino;
	private String indirizzo;
	private String citta;
	ArrayList<Articolo> articoli;
	
	public int getIdmagazzino() {
		return idmagazzino;
	}
	
	public void setIdmagazzino(int idmagazzino) {
		this.idmagazzino = idmagazzino;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public ArrayList<Articolo> getArticoli() {
		return articoli;
	}
	
	public void setArticoli(ArrayList<Articolo> articoli) {
		this.articoli = articoli;
	}
}
