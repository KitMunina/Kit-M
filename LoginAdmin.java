package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField pivaField;
	Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		inizializzaFrame();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(LoginAdmin.class.getResource("/lock.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(310, 11, 80, 65);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginAdmin.class.getResource("/corner .png")));
		label.setBounds(64, 3, 333, 118);
		contentPane.add(label);
		
		JLabel lblPIva = new JLabel("P. IVA:");
		lblPIva.setForeground(Color.BLACK);
		lblPIva.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPIva.setBounds(35, 95, 54, 14);
		contentPane.add(lblPIva);
		
		pivaField = new JTextField();
		pivaField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		pivaField.setColumns(10);
		pivaField.setBackground(Color.WHITE);
		pivaField.setBounds(35, 120, 220, 20);
		contentPane.add(pivaField);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homepage h = new Homepage();
				h.setLocationRelativeTo(null);
				h.setVisible(true);
				dispose();
			}
		});
		
		JLabel errore = new JLabel("");
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(10, 163, 380, 18);
		contentPane.add(errore);
		button.setIcon(new ImageIcon(LoginAdmin.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 204, 35, 35);
		contentPane.add(button);
		
		JButton logbtn = new JButton("Accedi");
		logbtn.setIcon(new ImageIcon(LoginAdmin.class.getResource("/login_large.png")));
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pivaField.getText().isEmpty()) {
					errore.setText("* Inserire la partita iva!");
				}
				else {
					if(c.checkAdminLogin(pivaField.getText())) {
						dispose();
					}
				}
			}
		});
		logbtn.setForeground(Color.BLACK);
		logbtn.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		logbtn.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		logbtn.setBackground(SystemColor.menu);
		logbtn.setBounds(245, 204, 145, 35);
		contentPane.add(logbtn);
	}
}
