package main;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Model {
	private Controller c = new Controller();

	public DefaultTableModel allArticoliModel() {
		String col[] = {"ID","Nome","Prezzo","Taglia","Colore","Reparto","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = c.getAllArticoli();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getIdarticolo(), a.get(i).getNome(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(), a.get(i).getReparto(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
	
	public DefaultTableModel allMaleModel() {
		String col[] = {"Nome","Prezzo","Taglia","Colore","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = c.getAllMale();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getIdarticolo(), a.get(i).getNome(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
	
	public DefaultTableModel allUpperParts() {
		String col[] = {"Nome","Prezzo","Taglia","Colore","Reparto","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = c.getAllUpperParts();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getNome(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(),a.get(i).getReparto(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
	
	public DefaultTableModel allLowerParts() {
		String col[] = {"Nome","Prezzo","Taglia","Colore","Reparto","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = c.getAllLowerParts();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getNome(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(),a.get(i).getReparto(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
}
