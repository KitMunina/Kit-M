package main;

import java.util.ArrayList;
import java.util.List;

public class Amministratore {
	private String piva;
	private String nome;
	private String cognome;
	List<Articolo> articoli;
	
	public String getPiva() {
		return piva;
	}
	
	public void setPiva(String piva) {
		this.piva = piva;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}
}
