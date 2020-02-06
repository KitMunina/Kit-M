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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - dimension.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - dimension.getHeight()) / 2);
	    setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(109, 90, 180, 20);
		contentPane.add(email);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblEmail.setBounds(109, 66, 54, 14);
		contentPane.add(lblEmail);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		password.setBounds(109, 160, 180, 20);
		contentPane.add(password);
		
		JLabel lblPasswrod = new JLabel("Password:");
		lblPasswrod.setForeground(Color.WHITE);
		lblPasswrod.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPasswrod.setBounds(109, 135, 80, 14);
		contentPane.add(lblPasswrod);
		
		JLabel lblL = new JLabel("Login");
		lblL.setForeground(Color.WHITE);
		lblL.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblL.setBounds(10, 11, 180, 37);
		contentPane.add(lblL);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setBackground(SystemColor.menu);
		btnAccedi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnAccedi.setBounds(301, 216, 89, 23);
		contentPane.add(btnAccedi);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIndietro.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnIndietro.setBackground(SystemColor.menu);
		btnIndietro.setBounds(10, 216, 89, 23);
		contentPane.add(btnIndietro);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Login.class.getResource("/loginbackground.png")));
		background.setBounds(3, 3, 394, 244);
		contentPane.add(background);
	}
}
