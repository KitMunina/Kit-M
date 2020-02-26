package main;

import java.util.List;

public interface ArticoloDao {
	public List<Articolo> getAllArticoli();
	public List<Articolo> getAllMale();
	public List<Articolo> getAllFemale();
	public List<Articolo> getAllUpperParts();
	public List<Articolo> getAllLowerParts();
	public List<Articolo> getAllShoes();
	public List<Articolo> getAllOvercoats();
	public List<Articolo> getAllUnderwears();
	public List<Articolo> getAllAccessories();
	public boolean insertArticolo(Articolo artnuovo);
	public boolean updateArticolo(Articolo artedit);
	public boolean deleteArticolo(Articolo artremove);
	public void updateQuantityItemAfterPayment(int idarticolo, int quantita);
}
