package main;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Model {
	ArticoloDao dao = new ArticoloDaoImpl();

	public DefaultTableModel getAllArticoli() {
		String col[] = {"Nome","Descr.","Prezzo","Taglia","Colore","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = dao.getAllArticoli();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getIdarticolo(), a.get(i).getNome(), a.get(i).getDescrizione(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		return model;
	}
	
	public DefaultTableModel getAllMale() {
		String col[] = {"Nome","Descr.","Prezzo","Taglia","Colore","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = dao.getAllMale();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getIdarticolo(), a.get(i).getNome(), a.get(i).getDescrizione(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
	
	public DefaultTableModel getAllUpperParts() {
		String col[] = {"Nome","Descr.","Prezzo","Taglia","Colore","Reparto","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		List<Articolo> a = dao.getAllUpperParts();
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getNome(), a.get(i).getDescrizione(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(),a.get(i).getReparto(), a.get(i).getQuantita()};
			model.addRow(articoli);
		}
		
		model.fireTableDataChanged();
		
		return model;
	}
}
