package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ModificaArticolo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Controller c = new Controller();
	Model m = new Model();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaArticolo frame = new ModificaArticolo();
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
				    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
				    frame.setLocation(x, y);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
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
		label.setBounds(314, 3, 333, 94);
		contentPane.add(label);
		
		table = new JTable(m.allArticoliModel());
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Ts Cent MT", Font.PLAIN, 18));
		table.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		table.setBounds(10, 108, 630, 285);
		table.setRowHeight(50);
		table.setSelectionBackground(new Color(100, 149, 237));
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 108, 630, 285);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("* Si possono modificare solo le colonne \"Prezzo\",\"Taglia\",\"Colore\",\"Quantit\u00E1\".");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblNewLabel.setBounds(55, 404, 425, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					NOUPDATEpopup dialog = new NOUPDATEpopup();
					dialog.setVisible(true);
				}
				else {
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					String prz = table.getValueAt(table.getSelectedRow(), 3).toString();
					String taglia = table.getValueAt(table.getSelectedRow(), 4).toString();
					String colore = table.getValueAt(table.getSelectedRow(), 5).toString();
					String qta = table.getValueAt(table.getSelectedRow(), 7).toString();
					
					float prezzo = Float.parseFloat(prz);
					int quantita = Integer.parseInt(qta);

					Articolo artedit = c.findArticolo(id);
					c.updateArticolo(artedit);
				}
			}
		});
		btnAggiorna.setIcon(new ImageIcon(ModificaArticolo.class.getResource("/updatebutton_small.png")));
		btnAggiorna.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnAggiorna.setBackground(SystemColor.menu);
		btnAggiorna.setBounds(490, 404, 150, 35);
		contentPane.add(btnAggiorna);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("** L'operazione va effettuata per ogni modifica");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(55, 425, 425, 14);
		contentPane.add(lblNewLabel_1);
	}
}
