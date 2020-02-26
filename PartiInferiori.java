package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PartiInferiori extends JFrame {

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
					PartiInferiori frame = new PartiInferiori();
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
	public PartiInferiori() {
		inizializzaFrame();
		setLocationRelativeTo(null);
		
		List<Articolo> a = c.getAllLowerParts();
		String col[] = {"ID","Nome","Prezzo","Taglia","Colore","Reparto","Disponibilita"};
		DefaultTableModel model = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int col)
	        {
	            return false;
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
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(6).setPreferredWidth(59);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPartiInferiori = new JLabel("Parti inferiori");
		lblPartiInferiori.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblPartiInferiori.setBounds(10, 11, 233, 30);
		contentPane.add(lblPartiInferiori);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(100, 149, 237));
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label.setBounds(10, 52, 35, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Articolo");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(45, 52, 180, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Prezzo");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(100, 149, 237));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(221, 52, 80, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Taglia");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(100, 149, 237));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(299, 52, 75, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Colore");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(377, 52, 75, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Reparto");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(455, 52, 75, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Disp.");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(100, 149, 237));
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(531, 52, 59, 21);
		contentPane.add(label_6);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 65, 580, 233);
		table.setRowHeight(50);
		table.setTableHeader(null);
		table.setSelectionBackground(new Color(100, 149, 237));
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 580, 259);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(PartiInferiori.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 354, 35, 35);
		contentPane.add(button);
		
		JLabel lblqta = new JLabel("Quantit\u00E1:");
		lblqta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblqta.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblqta.setEnabled(false);
		lblqta.setBounds(270, 354, 80, 35);
		contentPane.add(lblqta);
		
		JSpinner quantitaSpin = new JSpinner();
		quantitaSpin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		quantitaSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		quantitaSpin.setEnabled(false);
		quantitaSpin.setBounds(360, 358, 60, 25);
		contentPane.add(quantitaSpin);
		
		JButton addtocart = new JButton("Aggiungi");
		addtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				Articolo temp = c.findArticolo(id);
				int quantita = Integer.parseInt(quantitaSpin.getValue().toString());
				
				if(temp.getDisponibilita() < quantita) {
					Errore e = new Errore();
					e.errore.setText("La quantitá richiesta non é disponibile!");
					e.setVisible(true);
				}
				else {					
					if(Homepage.loginstatuscustomer) {
						if(c.addToCart(temp.getIdarticolo(), Homepage.carrello.getIdcarrello(), quantita)) {
							OKpopup ok = new OKpopup();
							OKpopup.allert.setText("Articolo aggiunto nel carrello!");
							ok.setVisible(true);
						}
						else {
							Errore err = new Errore();
							err.errore.setText("Non é stato possibile aggiungere l'articolo nel carrello!");
							err.setVisible(true);
						}
					}
					else {
						Errore err = new Errore();
						err.errore.setText("Devi prima effettuare l'accesso!");
						err.setVisible(true);
					}					
				}
			}
		});
		addtocart.setIcon(new ImageIcon(PartiInferiori.class.getResource("/cart_large.png")));
		addtocart.setForeground(Color.BLACK);
		addtocart.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		addtocart.setEnabled(false);
		addtocart.setBorder(new LineBorder(Color.GRAY, 1, true));
		addtocart.setBackground(SystemColor.menu);
		addtocart.setBounds(430, 354, 160, 35);
		contentPane.add(addtocart);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					addtocart.setEnabled(false);
					lblqta.setEnabled(false);
					quantitaSpin.setEnabled(false);
				}
				else {
					addtocart.setEnabled(true);
					lblqta.setEnabled(true);
					quantitaSpin.setEnabled(true);
				}
			}
		});
	}
}
