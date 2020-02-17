package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accessori extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Model m = new Model();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accessori frame = new Accessori();
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
	public Accessori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorseEZaini = new JLabel("Accessori");
		lblBorseEZaini.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblBorseEZaini.setBounds(10, 11, 90, 30);
		contentPane.add(lblBorseEZaini);
		
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
		table.setModel(m.allAccessories());
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
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
		button.setIcon(new ImageIcon(Accessori.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 354, 35, 35);
		contentPane.add(button);
		
		JButton addtocart = new JButton("Aggiungi");
		addtocart.setIcon(new ImageIcon(Accessori.class.getResource("/cart_large.png")));
		addtocart.setForeground(Color.BLACK);
		addtocart.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		addtocart.setEnabled(false);
		addtocart.setBorder(new LineBorder(Color.GRAY, 1, true));
		addtocart.setBackground(SystemColor.menu);
		addtocart.setBounds(430, 354, 160, 35);
		contentPane.add(addtocart);
		
		JLabel lblArticolo = new JLabel("Articolo");
		lblArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticolo.setForeground(new Color(100, 149, 237));
		lblArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblArticolo.setBounds(10, 52, 200, 21);
		contentPane.add(lblArticolo);
		
		JLabel label_1 = new JLabel("Prezzo");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(209, 52, 75, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Taglia");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(100, 149, 237));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(285, 52, 75, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Colore");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(100, 149, 237));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(362, 52, 75, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Reparto");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(100, 149, 237));
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(439, 52, 75, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Q.t\u00E1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(515, 52, 75, 21);
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
			};
		});
	}

}
