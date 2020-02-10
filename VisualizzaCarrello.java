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
import javax.swing.JScrollPane;

public class VisualizzaCarrello extends JFrame {

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
					VisualizzaCarrello frame = new VisualizzaCarrello();
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
	public VisualizzaCarrello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarrello = new JLabel("Carrello");
		lblCarrello.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarrello.setForeground(Color.BLACK);
		lblCarrello.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblCarrello.setBounds(10, 11, 110, 25);
		contentPane.add(lblCarrello);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(VisualizzaCarrello.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 354, 35, 35);
		contentPane.add(button);
		
		JButton btnVaiAllaCassa = new JButton("Vai alla cassa");
		btnVaiAllaCassa.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnVaiAllaCassa.setBackground(SystemColor.menu);
		btnVaiAllaCassa.setBounds(440, 354, 150, 35);
		contentPane.add(btnVaiAllaCassa);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setShowVerticalLines(false);
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		table.setBounds(10, 65, 580, 233);
		table.setRowHeight(50);
		table.setTableHeader(null);
		table.setModel(m.allUpperParts());
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 580, 264);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("Nome");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label.setBounds(10, 47, 84, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Descr.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(93, 47, 84, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Prezzo");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(175, 47, 84, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Taglia");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(258, 47, 84, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Colore");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(340, 47, 84, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Reparto");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(422, 47, 84, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Q.t\u00E1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(506, 47, 84, 21);
		contentPane.add(label_6);
	}
}
