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
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MioAccount extends JFrame {

	private JPanel contentPane;
	Controller c = new Controller();
	private JTextField accountInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MioAccount frame = new MioAccount();
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
	public MioAccount() {
		inizializzaFrame();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Il mio account");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 730, 24);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(MioAccount.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 454, 35, 35);
		contentPane.add(button);
		
		JButton btnModificaImpostazioni = new JButton("Impostazioni");
		btnModificaImpostazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificaAccount edit = new ModificaAccount();
				edit.setVisible(true);
			}
		});
		btnModificaImpostazioni.setIcon(new ImageIcon(MioAccount.class.getResource("/usersettings.png")));
		btnModificaImpostazioni.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificaImpostazioni.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificaImpostazioni.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnModificaImpostazioni.setBackground(SystemColor.menu);
		btnModificaImpostazioni.setBounds(182, 119, 180, 200);
		contentPane.add(btnModificaImpostazioni);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Homepage.cliente = null;
				Homepage.carrello = null;
				Homepage.cartbutton.setEnabled(false);
				Homepage.adminlogin.setEnabled(true);
				Homepage.loginstatusadmin = false;
				Homepage.loginstatuscustomer = false;
				Homepage.username.setText(null);
				
				OKpopup ok = new OKpopup();
				OKpopup.allert.setText("Sei stato disconnesso da Kit&M!");
				ok.setVisible(true);
			}
		});
		btnLogout.setIcon(new ImageIcon(MioAccount.class.getResource("/logouticon.png")));
		btnLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogout.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnLogout.setBackground(SystemColor.menu);
		btnLogout.setBounds(393, 119, 180, 200);
		contentPane.add(btnLogout);
		
		JLabel lblModificaLaPassword = new JLabel("Modifica la password");
		lblModificaLaPassword.setForeground(new Color(30, 144, 255));
		lblModificaLaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaLaPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblModificaLaPassword.setBounds(182, 330, 182, 18);
		contentPane.add(lblModificaLaPassword);
		
		JLabel lblOLindirizzoDi = new JLabel("o il tuo l'indirizzo di");
		lblOLindirizzoDi.setForeground(new Color(30, 144, 255));
		lblOLindirizzoDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblOLindirizzoDi.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblOLindirizzoDi.setBounds(182, 348, 182, 18);
		contentPane.add(lblOLindirizzoDi);
		
		JLabel lblSpedizione = new JLabel("spedizione");
		lblSpedizione.setForeground(new Color(30, 144, 255));
		lblSpedizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpedizione.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblSpedizione.setBounds(184, 367, 182, 18);
		contentPane.add(lblSpedizione);
		
		JLabel lblEsciDaKitm = new JLabel("Esci da Kit&M");
		lblEsciDaKitm.setForeground(new Color(30, 144, 255));
		lblEsciDaKitm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsciDaKitm.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblEsciDaKitm.setBounds(393, 330, 182, 18);
		contentPane.add(lblEsciDaKitm);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MioAccount.class.getResource("/corner .png")));
		lblNewLabel_2.setBounds(414, 3, 333, 118);
		contentPane.add(lblNewLabel_2);
		
		accountInfo = new JTextField();
		accountInfo.setHorizontalAlignment(SwingConstants.LEFT);
		accountInfo.setBackground(Color.WHITE);
		accountInfo.setEditable(false);
		accountInfo.setForeground(new Color(30, 144, 255));
		accountInfo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		accountInfo.setBounds(10, 46, 525, 27);
		accountInfo.setBorder(null);
		accountInfo.setText(Homepage.cliente.getNome()+" "+Homepage.cliente.getCognome()+", "+Homepage.cliente.getEmail());
		contentPane.add(accountInfo);
		accountInfo.setColumns(10);
	}
}
