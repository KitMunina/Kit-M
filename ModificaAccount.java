package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaAccount extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField indirizzoField;
	private JTextField cittaField;
	private JTextField emailField;
	private JPasswordField passwordField;
	Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaAccount frame = new ModificaAccount();
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
	
	public ModificaAccount() {
		inizializzaFrame();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 580, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(ModificaAccount.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 304, 35, 35);
		contentPane.add(button);
		
		JLabel lblModificaDati = new JLabel("Modifica dati");
		lblModificaDati.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblModificaDati.setBounds(10, 11, 560, 30);
		contentPane.add(lblModificaDati);
		
		JLabel label = new JLabel("Nome:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label.setBounds(111, 65, 50, 23);
		contentPane.add(label);
		
		nomeField = new JTextField();
		nomeField.setText(Homepage.cliente.getNome());
		nomeField.setHorizontalAlignment(SwingConstants.CENTER);
		nomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		nomeField.setEditable(false);
		nomeField.setColumns(10);
		nomeField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nomeField.setBackground(Color.WHITE);
		nomeField.setBounds(171, 65, 240, 23);
		contentPane.add(nomeField);
		
		JLabel label_1 = new JLabel("Cognome:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(82, 99, 79, 23);
		contentPane.add(label_1);
		
		cognomeField = new JTextField();
		cognomeField.setText(Homepage.cliente.getCognome());
		cognomeField.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cognomeField.setEditable(false);
		cognomeField.setColumns(10);
		cognomeField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cognomeField.setBackground(Color.WHITE);
		cognomeField.setBounds(171, 99, 240, 23);
		contentPane.add(cognomeField);
		
		JLabel label_2 = new JLabel("Indirizzo:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(30, 144, 255));
		label_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_2.setBounds(90, 201, 79, 23);
		contentPane.add(label_2);
		
		indirizzoField = new JTextField();
		indirizzoField.setHorizontalAlignment(SwingConstants.CENTER);
		indirizzoField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		indirizzoField.setColumns(10);
		indirizzoField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		indirizzoField.setBackground(Color.WHITE);
		indirizzoField.setBounds(171, 201, 240, 23);
		indirizzoField.setText(Homepage.cliente.getIndirizzo());
		contentPane.add(indirizzoField);
		
		JLabel label_3 = new JLabel("Citt\u00E1:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(30, 144, 255));
		label_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_3.setBounds(120, 235, 50, 23);
		contentPane.add(label_3);
		
		cittaField = new JTextField();
		cittaField.setHorizontalAlignment(SwingConstants.CENTER);
		cittaField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cittaField.setColumns(10);
		cittaField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cittaField.setBackground(Color.WHITE);
		cittaField.setBounds(171, 235, 240, 23);
		cittaField.setText(Homepage.cliente.getCitta());
		contentPane.add(cittaField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(30, 144, 255));
		lblEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblEmail.setBounds(114, 133, 50, 23);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setText(Homepage.cliente.getEmail());
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		emailField.setBackground(Color.WHITE);
		emailField.setBounds(171, 133, 240, 23);
		contentPane.add(emailField);
		
		JLabel lblNuovaPassword = new JLabel("Nuova password:");
		lblNuovaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuovaPassword.setForeground(new Color(30, 144, 255));
		lblNuovaPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNuovaPassword.setBounds(22, 167, 139, 23);
		contentPane.add(lblNuovaPassword);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		passwordField.setBounds(171, 167, 240, 23);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setText(Homepage.cliente.getPassword());
		contentPane.add(passwordField);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ModificaAccount.class.getResource("/corner .png")));
		label_4.setBounds(261, 3, 316, 118);
		contentPane.add(label_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificaAccount.class.getResource("/usersettings.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(436, 85, 134, 173);
		contentPane.add(lblNewLabel);
		
		JLabel allert = new JLabel("");
		allert.setHorizontalAlignment(SwingConstants.CENTER);
		allert.setForeground(Color.RED);
		allert.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		allert.setBounds(10, 269, 560, 24);
		contentPane.add(allert);
		
		JButton aggiorna = new JButton("Aggiorna");
		aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((passwordField.getText().isEmpty()) || (indirizzoField.getText().isEmpty()) || (cittaField.getText().isEmpty())) {
					allert.setText("* Compila tutti i campi!");
				}
				else if ((Homepage.cliente.getPassword() != passwordField.getText()) || (Homepage.cliente.getIndirizzo() != indirizzoField.getText()) || (Homepage.cliente.getCitta() != cittaField.getText())) {
					if(c.updateCustomer(passwordField.getText(), indirizzoField.getText(), cittaField.getText())) {
						dispose();
						Homepage.cliente.setPassword(passwordField.getText());
						Homepage.cliente.setIndirizzo(indirizzoField.getText());
						Homepage.cliente.setCitta(cittaField.getText());
					
						OKpopup ok = new OKpopup();
						OKpopup.allert.setText("I dati sono stati aggiornati!");
						ok.setVisible(true);
					}
					else {
						Errore err = new Errore();
						Errore.errore.setText("Oops... qualcosa é andato storto");
						err.setVisible(true);
					}
				}
			}
		});
		aggiorna.setIcon(new ImageIcon(ModificaAccount.class.getResource("/updatebutton_small.png")));
		aggiorna.setForeground(Color.BLACK);
		aggiorna.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		aggiorna.setBorder(new LineBorder(Color.GRAY, 1, true));
		aggiorna.setBackground(SystemColor.menu);
		aggiorna.setBounds(410, 304, 160, 35);
		contentPane.add(aggiorna);
	}
}
