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
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

public class RimuoviArticolo extends JFrame {

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
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setShowVerticalLines(false);
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
		table.setModel(m.allArticoliModel());
		contentPane.add(table);
		
		JLabel lblPerEliminareUn = new JLabel("Per eliminare un articolo, seleziona una riga e clicca sul tasto rimuovi");
		lblPerEliminareUn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerEliminareUn.setForeground(Color.BLACK);
		lblPerEliminareUn.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblPerEliminareUn.setBounds(10, 49, 528, 25);
		contentPane.add(lblPerEliminareUn);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(10, 85, 97, 21);
		contentPane.add(label_1);
		
		JLabel lblArticolo = new JLabel("Articolo");
		lblArticolo.setForeground(new Color(100, 149, 237));
		lblArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblArticolo.setBounds(105, 85, 97, 21);
		contentPane.add(lblArticolo);
		
		JLabel label_4 = new JLabel("Prezzo");
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(203, 85, 97, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Taglia");
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(301, 85, 97, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Colore");
		label_6.setForeground(new Color(100, 149, 237));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(397, 85, 97, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Reparto");
		label_7.setForeground(new Color(100, 149, 237));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_7.setBounds(494, 85, 97, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Q.t\u00E1");
		label_8.setForeground(new Color(100, 149, 237));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_8.setBounds(593, 85, 97, 21);
		contentPane.add(label_8);
		
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
							String id = table.getValueAt(table.getSelectedRow(), 0).toString();
							
							Articolo artremove = c.findArticolo(id);
							if(c.deleteArticolo(artremove)) {
								new OKpopup().setVisible(true);
								table.setModel(m.allArticoliModel());
								rimuovibutton.setEnabled(false);
							}
							else {
								new Errore().setVisible(true);
							}
						}
					});
				}
			}
		});
	}
}
