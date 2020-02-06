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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PartiSuperiori extends JFrame {

	private JPanel contentPane;
	Model m = new Model();
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
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
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
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setShowVerticalLines(false);
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 65, 580, 233);
		table.setRowHeight(50);
		contentPane.add(table);
		table.setTableHeader(null);
		table.setModel(m.getAllUpperParts());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 580, 259);
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
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 52, 84, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDescr = new JLabel("Descr.");
		lblDescr.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblDescr.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescr.setBounds(93, 52, 84, 21);
		contentPane.add(lblDescr);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrezzo.setBounds(175, 52, 84, 21);
		contentPane.add(lblPrezzo);
		
		JLabel lblTaglia = new JLabel("Taglia");
		lblTaglia.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTaglia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaglia.setBounds(258, 52, 84, 21);
		contentPane.add(lblTaglia);
		
		JLabel lblColore = new JLabel("Colore");
		lblColore.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblColore.setHorizontalAlignment(SwingConstants.CENTER);
		lblColore.setBounds(340, 52, 84, 21);
		contentPane.add(lblColore);
		
		JLabel lblReparto = new JLabel("Reparto");
		lblReparto.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblReparto.setHorizontalAlignment(SwingConstants.CENTER);
		lblReparto.setBounds(422, 52, 84, 21);
		contentPane.add(lblReparto);
		
		JLabel lblQt = new JLabel("Q.t\u00E1");
		lblQt.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblQt.setHorizontalAlignment(SwingConstants.CENTER);
		lblQt.setBounds(506, 52, 84, 21);
		contentPane.add(lblQt);
	}
}
