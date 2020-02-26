package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class RimuoviArticolo extends JFrame {

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
					RimuoviArticolo frame = new RimuoviArticolo();
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
	
	public RimuoviArticolo() {
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
		
		JLabel lblRimuoviUnArticolo = new JLabel("Rimuovi un articolo");
		lblRimuoviUnArticolo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRimuoviUnArticolo.setForeground(Color.BLACK);
		lblRimuoviUnArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblRimuoviUnArticolo.setBounds(10, 11, 412, 27);
		contentPane.add(lblRimuoviUnArticolo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RimuoviArticolo.class.getResource("/corner .png")));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(364, 3, 333, 94);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(RimuoviArticolo.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 404, 35, 35);
		contentPane.add(button);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setBackground(Color.WHITE);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("TW Cent MT", Font.PLAIN, 18));
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 108, 630, 285);
		table.setRowHeight(50);
		table.setSelectionBackground(new Color(100, 149, 237));
		table.setTableHeader(null);
		contentPane.add(table);
		
		JLabel lblPerEliminareUn = new JLabel("Per eliminare un articolo, seleziona una riga e clicca sul tasto rimuovi");
		lblPerEliminareUn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerEliminareUn.setForeground(Color.BLACK);
		lblPerEliminareUn.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblPerEliminareUn.setBounds(10, 49, 528, 25);
		contentPane.add(lblPerEliminareUn);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 117, 680, 276);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton rimuovibutton = new JButton("Rimuovi");
		rimuovibutton.setEnabled(false);
		rimuovibutton.setBorder(new LineBorder(Color.GRAY, 1, true));
		rimuovibutton.setIcon(new ImageIcon(RimuoviArticolo.class.getResource("/removebutton_small.png")));
		rimuovibutton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		rimuovibutton.setBackground(SystemColor.menu);
		rimuovibutton.setBounds(540, 404, 150, 35);
		contentPane.add(rimuovibutton);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(10, 85, 48, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Articolo");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(100, 149, 237));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(56, 85, 214, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Prezzo");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(100, 149, 237));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(270, 85, 89, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Taglia");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(360, 85, 87, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Colore");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(446, 85, 89, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Reparto");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(100, 149, 237));
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(534, 85, 89, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Q.t\u00E1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(100, 149, 237));
		label_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_7.setBounds(623, 85, 49, 21);
		contentPane.add(label_7);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					rimuovibutton.setEnabled(false);
				}
				else {
					rimuovibutton.setEnabled(true);
					rimuovibutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
							
							Articolo artremove = c.findArticolo(id);
							if(c.deleteArticolo(artremove)) {
								((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
								OKpopup ok = new OKpopup();
								ok.setVisible(true);
								rimuovibutton.setEnabled(false);
							}
							else {
								Errore err = new Errore();
								err.setVisible(true);
							}
						}
					});
				}
			}
		});
	}
}
