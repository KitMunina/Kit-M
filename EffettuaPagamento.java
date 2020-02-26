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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.Year;
import java.util.Calendar;

public class EffettuaPagamento extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField indirizzoField;
	private JTextField cittaField;
	private JTextField ncartaField;
	private JTextField cvvField;
	private JTextField meseField;
	private JTextField annoField;
	private JTextField textField;
	Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EffettuaPagamento frame = new EffettuaPagamento();
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
	public EffettuaPagamento() {
		inizializzaFrame();
		setLocationRelativeTo(null);		
	}
	
	private void inizializzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 600, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCassa = new JLabel("Cassa");
		lblCassa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCassa.setForeground(Color.BLACK);
		lblCassa.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblCassa.setBounds(10, 11, 72, 25);
		contentPane.add(lblCassa);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/lock.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(529, 11, 50, 67);
		contentPane.add(label_4);
		button.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/backbutton.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setBounds(10, 394, 35, 35);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/corner .png")));
		label_2.setBounds(264, 3, 333, 118);
		contentPane.add(label_2);
		
		JLabel lblDatiDelCliente = new JLabel("Dati del cliente");
		lblDatiDelCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatiDelCliente.setForeground(Color.BLACK);
		lblDatiDelCliente.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblDatiDelCliente.setBounds(10, 53, 119, 21);
		contentPane.add(lblDatiDelCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setForeground(new Color(30, 144, 255));
		lblNome.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNome.setBounds(170, 84, 50, 23);
		contentPane.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBackground(Color.WHITE);
		nomeField.setEditable(false);
		nomeField.setHorizontalAlignment(SwingConstants.CENTER);
		nomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		nomeField.setBounds(230, 84, 140, 23);
		nomeField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nomeField.setText(Homepage.cliente.getNome());
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setForeground(new Color(30, 144, 255));
		lblCognome.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblCognome.setBounds(141, 118, 79, 23);
		contentPane.add(lblCognome);
		
		cognomeField = new JTextField();
		cognomeField.setBackground(Color.WHITE);
		cognomeField.setEditable(false);
		cognomeField.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cognomeField.setColumns(10);
		cognomeField.setBounds(230, 118, 140, 23);
		cognomeField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cognomeField.setText(Homepage.cliente.getCognome());
		contentPane.add(cognomeField);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIndirizzo.setForeground(new Color(30, 144, 255));
		lblIndirizzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblIndirizzo.setBounds(149, 152, 71, 23);
		contentPane.add(lblIndirizzo);
		
		indirizzoField = new JTextField();
		indirizzoField.setBackground(Color.WHITE);
		indirizzoField.setEditable(false);
		indirizzoField.setHorizontalAlignment(SwingConstants.CENTER);
		indirizzoField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		indirizzoField.setColumns(10);
		indirizzoField.setBounds(230, 152, 140, 23);
		indirizzoField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		indirizzoField.setText(Homepage.cliente.getIndirizzo());
		contentPane.add(indirizzoField);
		
		JLabel lblCitt = new JLabel("Citt\u00E1:");
		lblCitt.setHorizontalAlignment(SwingConstants.LEFT);
		lblCitt.setForeground(new Color(30, 144, 255));
		lblCitt.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblCitt.setBounds(179, 186, 41, 23);
		contentPane.add(lblCitt);
		
		cittaField = new JTextField();
		cittaField.setBackground(Color.WHITE);
		cittaField.setEditable(false);
		cittaField.setHorizontalAlignment(SwingConstants.CENTER);
		cittaField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cittaField.setColumns(10);
		cittaField.setBounds(230, 186, 140, 23);
		cittaField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cittaField.setText(Homepage.cliente.getCitta());
		contentPane.add(cittaField);
		
		JLabel label = new JLabel("_________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		label.setBounds(17, 209, 580, 25);
		contentPane.add(label);
		
		JLabel lblDatiPagamento = new JLabel("Dati pagamento");
		lblDatiPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatiPagamento.setForeground(Color.BLACK);
		lblDatiPagamento.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblDatiPagamento.setBounds(10, 263, 129, 21);
		contentPane.add(lblDatiPagamento);
		
		JLabel lblNCarta = new JLabel("N. Carta:");
		lblNCarta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNCarta.setForeground(new Color(30, 144, 255));
		lblNCarta.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNCarta.setBounds(113, 295, 73, 23);
		contentPane.add(lblNCarta);
		
		ncartaField = new JTextField();
		ncartaField.setHorizontalAlignment(SwingConstants.CENTER);
		ncartaField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		ncartaField.setColumns(10);
		ncartaField.setBounds(196, 295, 210, 23);
		ncartaField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(ncartaField);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setHorizontalAlignment(SwingConstants.LEFT);
		lblCvv.setForeground(new Color(30, 144, 255));
		lblCvv.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblCvv.setBounds(90, 329, 41, 23);
		contentPane.add(lblCvv);
		
		cvvField = new JTextField();
		cvvField.setHorizontalAlignment(SwingConstants.CENTER);
		cvvField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cvvField.setColumns(10);
		cvvField.setBounds(141, 330, 65, 23);
		cvvField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(cvvField);
		
		JLabel lblScadenza = new JLabel("Scadenza:");
		lblScadenza.setHorizontalAlignment(SwingConstants.LEFT);
		lblScadenza.setForeground(new Color(30, 144, 255));
		lblScadenza.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblScadenza.setBounds(256, 330, 83, 23);
		contentPane.add(lblScadenza);
		
		meseField = new JTextField();
		meseField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				meseField.setText("");
			}
		});
		meseField.setText("MM");
		meseField.setHorizontalAlignment(SwingConstants.CENTER);
		meseField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		meseField.setColumns(10);
		meseField.setBounds(349, 330, 50, 23);
		meseField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(meseField);
		
		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(409, 329, 10, 23);
		contentPane.add(label_1);
		
		annoField = new JTextField();
		annoField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				annoField.setText("");
			}
		});
		annoField.setText("AAAA");
		annoField.setHorizontalAlignment(SwingConstants.CENTER);
		annoField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		annoField.setColumns(10);
		annoField.setBounds(429, 329, 75, 23);
		annoField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(annoField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/creditcardscircuits.png")));
		lblNewLabel.setBounds(55, 400, 379, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/userpayment.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(139, 47, 35, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/creditpayment.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(149, 255, 35, 35);
		contentPane.add(label_3);
		
		JLabel errore = new JLabel("");
		errore.setHorizontalAlignment(SwingConstants.LEFT);
		errore.setForeground(Color.RED);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(196, 263, 353, 21);
		contentPane.add(errore);
		
		JButton pagabtn = new JButton("Paga");
		pagabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((ncartaField.getText().isEmpty()) || (cvvField.getText().isEmpty()) || (meseField.getText().isEmpty()) || (annoField.getText().isEmpty())) {
					errore.setText("* Compilare tutti i campi relativi al pagamento!");
				}
				else if((ncartaField.getText().length() != 16) || (cvvField.getText().length() != 3) || (meseField.getText().length() != 2) || (Integer.parseInt(meseField.getText()) > 12) || (annoField.getText().length() != 4)) {
					errore.setText("* Campi incorretti!");
				}
				else {
					if((c.insertOrder()) && (c.insertOrderPayment(Homepage.cliente, VisualizzaCarrello.tot))) {
						dispose();
						c.insertOrderDetails();
						c.updateQuantityItemAfterPayment();
						c.svuotaCarrello(Homepage.carrello);
						errore.setVisible(false);
						OKpopup ok = new OKpopup();
						OKpopup.allert.setText("Grazie "+Homepage.cliente.getNome()+" per aver acquistato in Kit&M!");
						ok.setVisible(true);
					}
				}
			}
		});
		pagabtn.setIcon(new ImageIcon(EffettuaPagamento.class.getResource("/paymentconfirm.png")));
		pagabtn.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		pagabtn.setBackground(SystemColor.menu);
		pagabtn.setBounds(455, 394, 135, 35);
		contentPane.add(pagabtn);
		
		textField = new JTextField();
		textField.setText(String.valueOf(VisualizzaCarrello.tot));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(100, 149, 237));
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setBounds(355, 400, 90, 25);
		contentPane.add(textField);
		
		JLabel label_5 = new JLabel("Totale:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(297, 400, 56, 25);
		contentPane.add(label_5);
	}
}
