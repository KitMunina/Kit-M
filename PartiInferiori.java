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

public class PartiInferiori extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Model m = new Model();
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
		
		table = new JTable();
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setBounds(10, 84, 580, 50);
		table.setTableHeader(null);
		table.setModel(m.allLowerParts());
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(10, 84, 580, 259);
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
		
		JButton addtocart = new JButton("Aggiungi");
		addtocart.setIcon(new ImageIcon(PartiInferiori.class.getResource("/cart_large.png")));
		addtocart.setForeground(Color.BLACK);
		addtocart.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		addtocart.setEnabled(false);
		addtocart.setBorder(new LineBorder(Color.GRAY, 1, true));
		addtocart.setBackground(SystemColor.menu);
		addtocart.setBounds(430, 354, 160, 35);
		contentPane.add(addtocart);
		
		JLabel label = new JLabel("Nome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label.setBounds(10, 52, 95, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Prezzo");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(106, 52, 95, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Taglia");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(201, 52, 95, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Colore");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(298, 52, 95, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Reparto");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(396, 52, 95, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Q.t\u00E1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(493, 52, 97, 21);
		contentPane.add(label_5);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					addtocart.setEnabled(false);
				}
				else {
					addtocart.setEnabled(true);
				}
			}
		});
	}
}
