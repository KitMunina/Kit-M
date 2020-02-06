package main;

public class Articolo {
	private String idarticolo;
	private String nome;
	private String descrizione;
	private float prezzo;
	private String taglia;
	private String colore;
	private String reparto;
	private int quantita;
	
	public String getIdarticolo() {
		return idarticolo;
	}
	
	public void setIdarticolo(String idarticolo) {
		this.idarticolo = idarticolo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getTaglia() {
		return taglia;
	}
	
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	
	public String getColore() {
		return colore;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public String getReparto() {
		return reparto;
	}
	
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
