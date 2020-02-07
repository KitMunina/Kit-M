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

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
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
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/lock.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(310, 11, 80, 65);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/corner .png")));
		label.setBounds(64, 3, 333, 118);
		contentPane.add(label);
		
		JLabel errore = new JLabel("");
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(10, 175, 380, 18);
		contentPane.add(errore);
		button.setIcon(new ImageIcon(Login.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 204, 35, 35);
		contentPane.add(button);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setForeground(Color.BLACK);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(email.getText().isEmpty() || password.getText().isEmpty()) {
					errore.setText("* Compilare tutti i campi!");
				}
				else {
					if(c.checkUserLogin(email.getText(), password.getText())) {
						dispose();
					}
				}
			}
		});
		btnAccedi.setBackground(SystemColor.menu);
		btnAccedi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnAccedi.setBounds(210, 204, 180, 35);
		contentPane.add(btnAccedi);
	}
}
