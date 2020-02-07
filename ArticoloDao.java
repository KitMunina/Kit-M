package main;

import java.util.List;

public interface ArticoloDao {
	public List<Articolo> getAllArticoli();
	public List<Articolo> getAllMale();
	public List<Articolo> getAllFemale();
	public List<Articolo> getAllUpperParts();
	public void insertArticolo(Articolo artnuovo);
	public void updateArticolo(Articolo artedit);
}
