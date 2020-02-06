package main;

import java.util.List;

public interface ArticoloDao {
	public List<Articolo> getAllArticoli(); //restituisce tutti gli articoli in magazzino
	public List<Articolo> getAllMale(); //restituisce tutti i capi maschili
	public List<Articolo> getAllUpperParts(); //restituisce tutti gli articoli "parti superiori"
}
