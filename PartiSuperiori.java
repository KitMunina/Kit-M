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
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class PartiSuperiori extends JFrame {

	private JPanel contentPane;
	Model m = new Model();
	Controller c = new Controller();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartiSuperiori frame = new PartiSuperiori();
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
	public PartiSuperiori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Parti superiori");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 233, 30);
		contentPane.add(lblNewLabel);
		
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
		table.setModel(m.allUpperParts());
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 580, 259);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(PartiSuperiori.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 354, 35, 35);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 52, 200, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setForeground(new Color(100, 149, 237));
		lblPrezzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrezzo.setBounds(209, 52, 75, 21);
		contentPane.add(lblPrezzo);
		
		JLabel lblTaglia = new JLabel("Taglia");
		lblTaglia.setForeground(new Color(100, 149, 237));
		lblTaglia.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTaglia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaglia.setBounds(285, 52, 75, 21);
		contentPane.add(lblTaglia);
		
		JLabel lblColore = new JLabel("Colore");
		lblColore.setForeground(new Color(100, 149, 237));
		lblColore.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblColore.setHorizontalAlignment(SwingConstants.CENTER);
		lblColore.setBounds(362, 52, 75, 21);
		contentPane.add(lblColore);
		
		JLabel lblReparto = new JLabel("Reparto");
		lblReparto.setForeground(new Color(100, 149, 237));
		lblReparto.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblReparto.setHorizontalAlignment(SwingConstants.CENTER);
		lblReparto.setBounds(439, 52, 75, 21);
		contentPane.add(lblReparto);
		
		JLabel lblQt = new JLabel("Q.t\u00E1");
		lblQt.setForeground(new Color(100, 149, 237));
		lblQt.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblQt.setHorizontalAlignment(SwingConstants.CENTER);
		lblQt.setBounds(515, 52, 75, 21);
		contentPane.add(lblQt);
		
		JButton addtocart = new JButton("Aggiungi");
		addtocart.setIcon(new ImageIcon(PartiSuperiori.class.getResource("/cart_large.png")));
		addtocart.setEnabled(false);
		addtocart.setForeground(Color.BLACK);
		addtocart.setBorder(new LineBorder(Color.GRAY, 1, true));
		addtocart.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		addtocart.setBackground(SystemColor.menu);
		addtocart.setBounds(430, 354, 160, 35);
		contentPane.add(addtocart);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					addtocart.setEnabled(false);
				}
				else {
					addtocart.setEnabled(true);
				}
			};
		});
	}
}
