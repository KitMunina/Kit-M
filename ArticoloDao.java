package main;

import java.util.List;

public interface ArticoloDao {
	public List<Articolo> getAllArticoli();
	public List<Articolo> getAllMale();
	public List<Articolo> getAllFemale();
	public List<Articolo> getAllUpperParts();
	public List<Articolo> getAllLowerParts();
	public boolean insertArticolo(Articolo artnuovo);
	public boolean updateArticolo(Articolo artedit);
	public boolean deleteArticolo(Articolo artremove);
}
