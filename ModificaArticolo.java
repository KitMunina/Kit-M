package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;

public class ModificaArticolo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Controller c = new Controller();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaArticolo frame = new ModificaArticolo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificaArticolo() {
		inizializzaFrame();
		setLocationRelativeTo(null);
		
		List<Articolo> a = c.getAllArticoli();
		String col[] = {"ID","Nome","Prezzo","Taglia","Colore","Reparto","Disponibilita"};
		DefaultTableModel model = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int col)
	        {
	            return col == 2 || col == 3 || col == 4 || col == 6;
	        }
	    };
		
		for(int i=0; i<a.size(); i++) {
			Object[] articoli = {a.get(i).getIdarticolo(), a.get(i).getNome(), a.get(i).getPrezzo(), a.get(i).getTaglia(), a.get(i).getColore(),a.get(i).getReparto(), a.get(i).getDisponibilita()};
			model.addRow(articoli);
		}
				
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(35);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("");
		backbutton.setBackground(Color.WHITE);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		backbutton.setIcon(new ImageIcon(AggiungiArticolo.class.getResource("/backbutton.png")));
		backbutton.setBorder(BorderFactory.createEmptyBorder());
		backbutton.setBounds(10, 404, 35, 35);
		contentPane.add(backbutton);
		
		JLabel lblModificaArticoloEsistente = new JLabel("Modifica articolo esistente");
		lblModificaArticoloEsistente.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificaArticoloEsistente.setForeground(Color.BLACK);
		lblModificaArticoloEsistente.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblModificaArticoloEsistente.setBounds(10, 11, 326, 25);
		contentPane.add(lblModificaArticoloEsistente);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificaArticolo.class.getResource("/corner .png")));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(364, 3, 333, 94);
		contentPane.add(label);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("TW Cent MT", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 108, 630, 285);
		table.setRowHeight(50);
		table.setSelectionBackground(new Color(100, 149, 237));
		table.setTableHeader(null);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 680, 253);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Taglia pu\u00F3 essere: 'S', 'M', 'L', 'XL', 'Unica', '36', '37', '38 ', '39', '40', '41', '42', '43', '44'");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblNewLabel.setBounds(55, 412, 425, 16);
		contentPane.add(lblNewLabel);
		
		JButton updatebtn = new JButton("Aggiorna");
		updatebtn.setEnabled(false);
		updatebtn.setIcon(new ImageIcon(ModificaArticolo.class.getResource("/updatebutton_small.png")));
		updatebtn.setBorder(new LineBorder(Color.GRAY, 1, true));
		updatebtn.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		updatebtn.setBackground(SystemColor.menu);
		updatebtn.setBounds(540, 404, 150, 35);
		contentPane.add(updatebtn);
		
		JLabel lblInserireIlNuovo = new JLabel("Per modificare un elemento, fare doppio click sulla cella desiderata e inserire il nuovo valore. *");
		lblInserireIlNuovo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInserireIlNuovo.setForeground(Color.BLACK);
		lblInserireIlNuovo.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblInserireIlNuovo.setBounds(10, 47, 630, 25);
		contentPane.add(lblInserireIlNuovo);
		
		JLabel lblSuccessivamenteCliccareInvio = new JLabel("Successivamente cliccare invio e poi sul tasto \"Aggiorna\". **");
		lblSuccessivamenteCliccareInvio.setHorizontalAlignment(SwingConstants.LEFT);
		lblSuccessivamenteCliccareInvio.setForeground(Color.BLACK);
		lblSuccessivamenteCliccareInvio.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblSuccessivamenteCliccareInvio.setBounds(10, 72, 630, 25);
		contentPane.add(lblSuccessivamenteCliccareInvio);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(10, 108, 48, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Articolo");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(100, 149, 237));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(56, 108, 214, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Prezzo");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(100, 149, 237));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(270, 108, 89, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Taglia");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(360, 108, 87, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Colore");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(446, 108, 89, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Reparto");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(100, 149, 237));
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(534, 108, 89, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Q.t\u00E1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(100, 149, 237));
		label_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_7.setBounds(623, 108, 49, 21);
		contentPane.add(label_7);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					updatebtn.setEnabled(false);
				}
				else {
					updatebtn.setEnabled(true);
					updatebtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
							String prz = table.getValueAt(table.getSelectedRow(), 2).toString();
							String taglia = table.getValueAt(table.getSelectedRow(), 3).toString();
							String colore = table.getValueAt(table.getSelectedRow(), 4).toString();
							String qta = table.getValueAt(table.getSelectedRow(), 6).toString();
							
							float prezzo = Float.parseFloat(prz);
							int quantita = Integer.parseInt(qta);
							
							Articolo artedit = c.findArticolo(id);
							artedit.setPrezzo(prezzo);
							artedit.setTaglia(taglia);
							artedit.setColore(colore);
							artedit.setDisponibilita(quantita);
														
							if(c.updateArticolo(artedit)) {
								OKpopup ok = new OKpopup();
								OKpopup.allert.setText("Articolo aggiornato correttamente!");
								ok.setVisible(true);
								updatebtn.setEnabled(false);
							}
							else {
								Errore e = new Errore();
								Errore.errore.setText("Controlla di aver inserito correttamente i dati!");
								e.setVisible(true);
							}
						}
					});
				}
			}
		});
	}
}
