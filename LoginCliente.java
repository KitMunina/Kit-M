package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginCliente extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
					frame.setLocationRelativeTo(null);
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
	public LoginCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(35, 83, 220, 20);
		contentPane.add(email);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblEmail.setBounds(35, 58, 54, 14);
		contentPane.add(lblEmail);
		
		password = new JPasswordField();
		password.setToolTipText("");
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		password.setBounds(35, 144, 220, 20);
		contentPane.add(password);
		
		JLabel lblPasswrod = new JLabel("Password:");
		lblPasswrod.setForeground(Color.BLACK);
		lblPasswrod.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPasswrod.setBounds(35, 119, 80, 14);
		contentPane.add(lblPasswrod);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginCliente.class.getResource("/lock.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(310, 11, 80, 65);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginCliente.class.getResource("/corner .png")));
		label.setBounds(64, 3, 333, 118);
		contentPane.add(label);
		
		JLabel errore = new JLabel("");
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(10, 175, 380, 18);
		contentPane.add(errore);
		button.setIcon(new ImageIcon(LoginCliente.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 204, 35, 35);
		contentPane.add(button);
		
		JButton logbtn = new JButton("Accedi");
		logbtn.setIcon(new ImageIcon(LoginCliente.class.getResource("/login_large.png")));
		logbtn.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		logbtn.setForeground(Color.BLACK);
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(email.getText().isEmpty() || password.getText().isEmpty()) {
					errore.setText("* Inserire email e password!");
				}
				else {
					if(c.checkUserLogin(email.getText(), password.getText())) {
						dispose();
					}
				}
			}
		});
		logbtn.setBackground(SystemColor.menu);
		logbtn.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		logbtn.setBounds(245, 204, 145, 35);
		contentPane.add(logbtn);
	}
}
