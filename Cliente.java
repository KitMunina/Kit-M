package main;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int idcliente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String indirizzo;
	private String citta;
	
	public int getIdcliente() {
		return idcliente;
	}
	
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
}
