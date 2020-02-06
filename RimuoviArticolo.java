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

public class RimuoviArticolo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArticoloDAO a = new ArticoloDAO();

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
		setBounds(100, 100, 650, 450);
		setUndecorated(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
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
		label.setBounds(314, 3, 333, 94);
		contentPane.add(label);
		
		table = new JTable(a.getArticoli());
		table.setBackground(Color.WHITE);
		table.setSurrendersFocusOnKeystroke(true);
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
		
		JButton rimuovibutton = new JButton("Rimuovi");
		rimuovibutton.setIcon(new ImageIcon(RimuoviArticolo.class.getResource("/removebutton_small.png")));
		rimuovibutton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		rimuovibutton.setBackground(SystemColor.menu);
		rimuovibutton.setBounds(490, 404, 150, 35);
		contentPane.add(rimuovibutton);
		rimuovibutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					NOUPDATEpopup dialog = new NOUPDATEpopup();
					dialog.setVisible(true);
				}
				else {
					setEnabled(true);
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();

					a.rimuoviArticolo(id);
					table.setModel(a.getArticoli());
				}
			}
		});
	}
}
