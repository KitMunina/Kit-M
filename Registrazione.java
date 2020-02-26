package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cognome;
	private JTextField email;
	private JTextField indirizzo;
	private JTextField citta;
	private JPasswordField password;
	Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione frame = new Registrazione();
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
	
	public Registrazione() {
		inizializzaFrame();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrazione = new JLabel("Registrazione");
		lblRegistrazione.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblRegistrazione.setBounds(10, 11, 233, 30);
		contentPane.add(lblRegistrazione);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Registrazione.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 354, 35, 35);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 107, 75, 21);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		nome.setBounds(162, 106, 180, 22);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setForeground(new Color(30, 144, 255));
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblCognome.setBounds(77, 140, 75, 21);
		contentPane.add(lblCognome);
		
		cognome = new JTextField();
		cognome.setHorizontalAlignment(SwingConstants.CENTER);
		cognome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		cognome.setColumns(10);
		cognome.setBounds(162, 139, 180, 22);
		contentPane.add(cognome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(30, 144, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblEmail.setBounds(77, 173, 75, 21);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(162, 172, 180, 22);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(30, 144, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPassword.setBounds(77, 206, 75, 21);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		password.setBounds(162, 205, 180, 22);
		contentPane.add(password);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setForeground(new Color(30, 144, 255));
		lblIndirizzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIndirizzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblIndirizzo.setBounds(77, 239, 75, 21);
		contentPane.add(lblIndirizzo);
		
		indirizzo = new JTextField();
		indirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		indirizzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		indirizzo.setColumns(10);
		indirizzo.setBounds(162, 238, 180, 22);
		contentPane.add(indirizzo);
		
		JLabel lblCitta = new JLabel("Citta:");
		lblCitta.setForeground(new Color(30, 144, 255));
		lblCitta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCitta.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblCitta.setBounds(77, 272, 75, 21);
		contentPane.add(lblCitta);
		
		citta = new JTextField();
		citta.setHorizontalAlignment(SwingConstants.CENTER);
		citta.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		citta.setColumns(10);
		citta.setBounds(162, 271, 180, 22);
		contentPane.add(citta);
		
		JLabel errore = new JLabel("");
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(10, 315, 480, 21);
		contentPane.add(errore);
		
		JButton registra = new JButton("Registrati");
		registra.setIcon(new ImageIcon(Registrazione.class.getResource("/addbutton_small.png")));
		registra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((nome.getText().isEmpty()) || (cognome.getText().isEmpty()) || (email.getText().isEmpty()) || (password.getText().isEmpty()) || (indirizzo.getText().isEmpty()) || (citta.getText().isEmpty())) {
					errore.setText("* Compila tutti i campi!");
				}
				else {
					if(c.insertUser(nome.getText(), cognome.getText(), email.getText(), password.getText(), indirizzo.getText(), citta.getText())) {
						dispose();
						c.insertCart(email.getText(), password.getText());
						OKpopup ok = new OKpopup();
						OKpopup.allert.setText("Complimenti, ti sei registrato a Kit&M!");
						ok.setVisible(true);
					}
					else {
						Errore err = new Errore();
						Errore.errore.setText("Opss... qualcosa é andato storto");
						err.setVisible(true);
					}
				}
			}
		});
		registra.setForeground(Color.BLACK);
		registra.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		registra.setBorder(new LineBorder(Color.GRAY, 1, true));
		registra.setBackground(SystemColor.menu);
		registra.setBounds(330, 354, 160, 35);
		contentPane.add(registra);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Registrazione.class.getResource("/corner .png")));
		label.setBounds(164, 3, 333, 117);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Registrazione.class.getResource("/userpayment.png")));
		label_1.setBounds(10, 41, 480, 54);
		contentPane.add(label_1);
	}
}
