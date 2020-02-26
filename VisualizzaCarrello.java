package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class VisualizzaCarrello extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Controller c = new Controller();
	private JTextField totale;
	static JLabel narticoli;
	private static DecimalFormat df = new DecimalFormat("#.##");
	static float tot = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaCarrello frame = new VisualizzaCarrello();
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
	
	public VisualizzaCarrello() {
		inizializzaFrame();
		setLocationRelativeTo(null);
		
		List<ContenutoCarrello> cc = c.getCartContent(Homepage.carrello.getIdcarrello());
		String col[] = {"ID","Articolo","Prezzo","Taglia","Colore","Reparto","Quantita"};
		DefaultTableModel model = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int col)
	        {
	           return col == 6;
	        }
	    };
		
	    narticoli.setText("("+cc.size()+" articolo/i)");
		
		if(!cc.isEmpty()) {
			for(int i=0; i<cc.size(); i++) {
				Object[] contenuto = {cc.get(i).getIdarticolo(), c.findArticolo(cc.get(i).getIdarticolo()).getNome(), c.findArticolo(cc.get(i).getIdarticolo()).getPrezzo(), c.findArticolo(cc.get(i).getIdarticolo()).getTaglia(), c.findArticolo(cc.get(i).getIdarticolo()).getColore(), c.findArticolo(cc.get(i).getIdarticolo()).getReparto(), cc.get(i).getQuantita()};
				tot = tot + (c.findArticolo(cc.get(i).getIdarticolo()).getPrezzo() * cc.get(i).getQuantita());
				model.addRow(contenuto);
			}
			
			totale.setText(String.valueOf(df.format(tot))+" €");
			DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
			stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(35);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(6).setPreferredWidth(35);
		}
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarrello = new JLabel("Il mio carrello");
		lblCarrello.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarrello.setForeground(Color.BLACK);
		lblCarrello.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblCarrello.setBounds(10, 11, 167, 25);
		contentPane.add(lblCarrello);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tot = 0;
				dispose();
			}
		});
		
		narticoli = new JLabel("");
		narticoli.setHorizontalAlignment(SwingConstants.LEFT);
		narticoli.setForeground(Color.BLACK);
		narticoli.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		narticoli.setBounds(187, 11, 403, 25);
		contentPane.add(narticoli);
		
		button.setIcon(new ImageIcon(VisualizzaCarrello.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 391, 35, 35);
		contentPane.add(button);
		
		JButton paga = new JButton("Conferma e paga");
		paga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tot > 0) {
					dispose();
					EffettuaPagamento cassa = new EffettuaPagamento();
					cassa.setVisible(true);
				}
				else {
					Errore err = new Errore();
					Errore.errore.setText("Il tuo carrello é vuoto!");
					err.setVisible(true);
				}
			}
		});
		paga.setIcon(new ImageIcon(VisualizzaCarrello.class.getResource("/paymenticon.png")));
		paga.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		paga.setBackground(SystemColor.menu);
		paga.setBounds(390, 391, 200, 35);
		contentPane.add(paga);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 65, 580, 233);
		table.setRowHeight(50);
		table.setTableHeader(null);
		table.setSelectionBackground(new Color(100, 149, 237));
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 580, 265);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		totale = new JTextField();
		totale.setHorizontalAlignment(SwingConstants.LEFT);
		totale.setText("0,00 \u20AC");
		totale.setBorder(null);
		totale.setForeground(new Color(100, 149, 237));
		totale.setEditable(false);
		totale.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		totale.setBackground(Color.WHITE);
		totale.setBounds(453, 355, 137, 25);
		contentPane.add(totale);
		totale.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(100, 149, 237));
		lblId.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblId.setBounds(10, 47, 35, 21);
		contentPane.add(lblId);
		
		JLabel label = new JLabel("Articolo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(100, 149, 237));
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label.setBounds(45, 47, 200, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Prezzo");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(244, 47, 80, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Taglia");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(100, 149, 237));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(322, 47, 75, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Colore");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(100, 149, 237));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(400, 47, 75, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Reparto");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(478, 47, 75, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Q.t\u00E1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(554, 47, 36, 21);
		contentPane.add(label_5);
		
		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotale.setForeground(new Color(100, 149, 237));
		lblTotale.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTotale.setBounds(390, 355, 53, 25);
		contentPane.add(lblTotale);
		
		JButton editbutton = new JButton("");
		editbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idart = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				int qta = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
				Articolo temp = c.findArticolo(idart);
				
				if(qta <= temp.getDisponibilita()) {
					c.updateCartContent(idart, qta);
				}
				else {
					Errore err = new Errore();
					Errore.errore.setText("Attenzione, Max "+temp.getDisponibilita()+" pezzo/i!");
					table.setValueAt(temp.getDisponibilita(), table.getSelectedRow(), 6);
					err.setVisible(true);
				}
			}
		});
		editbutton.setEnabled(false);
		editbutton.setIcon(new ImageIcon(VisualizzaCarrello.class.getResource("/editcart.png")));
		editbutton.setBorder(BorderFactory.createEmptyBorder());
		editbutton.setBackground(Color.WHITE);
		editbutton.setBounds(281, 391, 35, 35);
		contentPane.add(editbutton);
		
		JButton deletebutton = new JButton("");
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idart = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				if(c.removeFromCart(idart)) {
					if(table.getRowCount() > 0) {
						float temprezzo = Float.parseFloat(table.getValueAt(table.getSelectedRow(), 2).toString());
						int tempqta = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
						tot = tot - (temprezzo * tempqta);
					}
					else {
						tot = 0;
					}
					
					totale.setText(String.valueOf(tot));
					
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
					
					narticoli.setText("("+table.getRowCount()+" articolo/i)");
					
					OKpopup ok = new OKpopup();
					OKpopup.allert.setText("L'articolo é stato rimosso dal carrello!");
					ok.setVisible(true);
				}
			}
		});
		deletebutton.setEnabled(false);
		deletebutton.setIcon(new ImageIcon(VisualizzaCarrello.class.getResource("/removefromcart.png")));
		deletebutton.setBorder(BorderFactory.createEmptyBorder());
		deletebutton.setBackground(Color.WHITE);
		deletebutton.setBounds(322, 391, 35, 35);
		contentPane.add(deletebutton);
		
		JLabel lblModificaORimuovi = new JLabel("Modifica o rimuovi");
		lblModificaORimuovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificaORimuovi.setForeground(Color.BLACK);
		lblModificaORimuovi.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblModificaORimuovi.setBounds(55, 391, 216, 35);
		contentPane.add(lblModificaORimuovi);
		
		JLabel narticolicart = new JLabel("");
		narticolicart.setHorizontalAlignment(SwingConstants.LEFT);
		narticolicart.setForeground(Color.BLACK);
		narticolicart.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		narticolicart.setBounds(187, 11, 167, 25);
		contentPane.add(narticolicart);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					editbutton.setEnabled(false);
					deletebutton.setEnabled(false);
				}
				else {
					editbutton.setEnabled(true);
					deletebutton.setEnabled(true);
				}
			};
		});
	}
}
