package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class AggiungiArticolo extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField coloreField;
	Controller c = new Controller();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggiungiArticolo frame = new AggiungiArticolo();
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
	public AggiungiArticolo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserisciNuovoArticolo = new JLabel("Inserisci un nuovo articolo");
		lblInserisciNuovoArticolo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInserisciNuovoArticolo.setForeground(Color.BLACK);
		lblInserisciNuovoArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblInserisciNuovoArticolo.setBounds(10, 11, 310, 25);
		contentPane.add(lblInserisciNuovoArticolo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNome.setBounds(82, 110, 53, 26);
		contentPane.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		nomeField.setColumns(10);
		nomeField.setBounds(145, 112, 155, 26);
		contentPane.add(nomeField);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrizione.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblDescrizione.setBounds(45, 134, 90, 26);
		contentPane.add(lblDescrizione);
		
		JComboBox<String> descrizioneCombo = new JComboBox<String>();
		descrizioneCombo.setMaximumRowCount(5);
		descrizioneCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		descrizioneCombo.setBackground(Color.WHITE);
		descrizioneCombo.setBounds(145, 147, 155, 26);
		contentPane.add(descrizioneCombo);
		descrizioneCombo.addItem("Tshirt");
		descrizioneCombo.addItem("Felpa");
		descrizioneCombo.addItem("Camicia");
		descrizioneCombo.addItem("Gonna");
		descrizioneCombo.addItem("Pantalone");
		descrizioneCombo.addItem("Giubbino");
		descrizioneCombo.addItem("Cappotto");
		descrizioneCombo.addItem("Intimo");
		descrizioneCombo.addItem("Scarpe");
		descrizioneCombo.addItem("Calzini");
		descrizioneCombo.addItem("Cappello");
		descrizioneCombo.addItem("Borsa");
		descrizioneCombo.addItem("Orologio");
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPrezzo.setBounds(69, 184, 66, 26);
		contentPane.add(lblPrezzo);
		
		JSpinner intSpin = new JSpinner();
		intSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		intSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		intSpin.setBackground(Color.WHITE);
		intSpin.setBounds(145, 184, 45, 26);
		contentPane.add(intSpin);
		
		JLabel label = new JLabel(",");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		label.setBounds(188, 185, 21, 25);
		contentPane.add(label);
		
		JSpinner decimalSpin = new JSpinner();
		decimalSpin.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		decimalSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		decimalSpin.setBackground(Color.WHITE);
		decimalSpin.setBounds(209, 184, 45, 26);
		contentPane.add(decimalSpin);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		label_1.setBounds(264, 185, 9, 25);
		contentPane.add(label_1);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaglia.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblTaglia.setBounds(69, 221, 66, 26);
		contentPane.add(lblTaglia);
		
		JComboBox<String> tagliaCombo = new JComboBox<String>();
		tagliaCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		tagliaCombo.setMaximumRowCount(5);
		tagliaCombo.setBackground(Color.WHITE);
		tagliaCombo.setBounds(145, 224, 75, 25);
		contentPane.add(tagliaCombo);
		tagliaCombo.addItem("S");
		tagliaCombo.addItem("M");
		tagliaCombo.addItem("L");
		tagliaCombo.addItem("XL");
		tagliaCombo.addItem("Unica");
		tagliaCombo.addItem("36");
		tagliaCombo.addItem("37");
		tagliaCombo.addItem("38");
		tagliaCombo.addItem("39");
		tagliaCombo.addItem("40");
		tagliaCombo.addItem("41");
		tagliaCombo.addItem("42");
		tagliaCombo.addItem("43");
		tagliaCombo.addItem("44");
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblColore.setBounds(79, 258, 56, 26);
		contentPane.add(lblColore);
		
		coloreField = new JTextField();
		coloreField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		coloreField.setColumns(10);
		coloreField.setBounds(145, 258, 155, 26);
		contentPane.add(coloreField);
		
		JLabel lblQuantit = new JLabel("Scorta:");
		lblQuantit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantit.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblQuantit.setBounds(229, 221, 53, 26);
		contentPane.add(lblQuantit);
		
		JSpinner quantitaSpin = new JSpinner();
		quantitaSpin.setBackground(Color.WHITE);
		quantitaSpin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		quantitaSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		quantitaSpin.setBounds(292, 221, 45, 26);
		contentPane.add(quantitaSpin);
		
		JLabel lblReparto = new JLabel("Reparto:");
		lblReparto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReparto.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblReparto.setBounds(55, 295, 80, 26);
		contentPane.add(lblReparto);
		
		JComboBox<String> repartoCombo = new JComboBox<String>();
		repartoCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		repartoCombo.setMaximumRowCount(5);
		repartoCombo.setBackground(Color.WHITE);
		repartoCombo.setBounds(145, 295, 155, 26);
		contentPane.add(repartoCombo);
		repartoCombo.addItem("Maschile");
		repartoCombo.addItem("Femminile");
		
		JLabel errore = new JLabel("");
		errore.setForeground(Color.RED);
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		errore.setBounds(10, 356, 630, 26);
		contentPane.add(errore);
		
		JButton backbutton = new JButton("");
		backbutton.setBackground(Color.WHITE);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		backbutton.setIcon(new ImageIcon(AggiungiArticolo.class.getResource("/backbutton.png")));
		backbutton.setBorder(BorderFactory.createEmptyBorder());
		backbutton.setBounds(10, 406, 35, 35);
		contentPane.add(backbutton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AggiungiArticolo.class.getResource("/forklift.jpg")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(409, 97, 231, 248);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon(AggiungiArticolo.class.getResource("/corner .png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(314, 3, 333, 94);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setIcon(new ImageIcon(AggiungiArticolo.class.getResource("/addbutton_small.png")));
		btnAggiungi.setBackground(SystemColor.menu);
		btnAggiungi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float prezzo = Float.parseFloat(intSpin.getValue().toString().concat(".").concat(decimalSpin.getValue().toString()));
				int qta = Integer.parseInt(quantitaSpin.getValue().toString());
				
				if((nomeField.getText().isEmpty()) || (coloreField.getText().isEmpty()) || (prezzo == 0) || (qta == 0)) {
					errore.setText("*Tutti i campi devono essere valorizzati correttamente!");;
				}
				else {
					errore.setVisible(false);
					
					Articolo artnuovo = new Articolo();
					artnuovo.setNome(nomeField.getText());
					artnuovo.setDescrizione(descrizioneCombo.getSelectedItem().toString());
					artnuovo.setPrezzo(prezzo);
					artnuovo.setTaglia(tagliaCombo.getSelectedItem().toString());
					artnuovo.setColore(coloreField.getText());
					artnuovo.setReparto(repartoCombo.getSelectedItem().toString());
					artnuovo.setDisponibilita(qta);
					
					if(c.insertArticolo(artnuovo)) {
						OKpopup ok = new OKpopup();
						OKpopup.allert.setText("Articolo aggiunto al database!");
						ok.setVisible(true);
					}
					else {
						Errore e = new Errore();
						e.setVisible(true);
					}
				}
			}
		});
		btnAggiungi.setBounds(490, 404, 150, 35);
		contentPane.add(btnAggiungi);
		
		descrizioneCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(descrizioneCombo.getSelectedItem().equals("Gonna")) {
					repartoCombo.setSelectedItem("Femminile");
				}
				
				if(descrizioneCombo.getSelectedItem().equals("Scarpe")) {
					tagliaCombo.setSelectedItem("36");
				}
			}
		});
	}
}
