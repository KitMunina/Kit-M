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
	private JTextField idField;
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
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
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
		
		JLabel lblNewLabel = new JLabel("ID Articolo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 97, 90, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		idField.setBounds(144, 97, 155, 26);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNome.setBounds(81, 134, 53, 26);
		contentPane.add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		nomeField.setColumns(10);
		nomeField.setBounds(144, 136, 155, 26);
		contentPane.add(nomeField);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrizione.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblDescrizione.setBounds(44, 171, 90, 26);
		contentPane.add(lblDescrizione);
		
		JComboBox<String> descrizioneCombo = new JComboBox<String>();
		descrizioneCombo.setMaximumRowCount(5);
		descrizioneCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		descrizioneCombo.setBackground(Color.WHITE);
		descrizioneCombo.setBounds(144, 171, 155, 26);
		contentPane.add(descrizioneCombo);
		descrizioneCombo.addItem("Tshirt");
		descrizioneCombo.addItem("Camicia");
		descrizioneCombo.addItem("Gonna");
		descrizioneCombo.addItem("Pantalone");
		descrizioneCombo.addItem("Cappotto");
		descrizioneCombo.addItem("Intimo");
		descrizioneCombo.addItem("Scarpe");
		descrizioneCombo.addItem("Calzini");
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblPrezzo.setBounds(68, 208, 66, 26);
		contentPane.add(lblPrezzo);
		
		JSpinner intSpin = new JSpinner();
		intSpin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		intSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		intSpin.setBackground(Color.WHITE);
		intSpin.setBounds(144, 208, 45, 26);
		contentPane.add(intSpin);
		
		JLabel label = new JLabel(",");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		label.setBounds(187, 209, 21, 25);
		contentPane.add(label);
		
		JSpinner decimalSpin = new JSpinner();
		decimalSpin.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		decimalSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		decimalSpin.setBackground(Color.WHITE);
		decimalSpin.setBounds(208, 208, 45, 26);
		contentPane.add(decimalSpin);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		label_1.setBounds(263, 209, 9, 25);
		contentPane.add(label_1);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaglia.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblTaglia.setBounds(68, 245, 66, 26);
		contentPane.add(lblTaglia);
		
		JComboBox<String> tagliaCombo = new JComboBox<String>();
		tagliaCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		tagliaCombo.setMaximumRowCount(5);
		tagliaCombo.setBackground(Color.WHITE);
		tagliaCombo.setBounds(144, 248, 75, 25);
		contentPane.add(tagliaCombo);
		tagliaCombo.addItem("S");
		tagliaCombo.addItem("M");
		tagliaCombo.addItem("L");
		tagliaCombo.addItem("XL");
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
		lblColore.setBounds(78, 282, 56, 26);
		contentPane.add(lblColore);
		
		coloreField = new JTextField();
		coloreField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		coloreField.setColumns(10);
		coloreField.setBounds(144, 282, 155, 26);
		contentPane.add(coloreField);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E1:");
		lblQuantit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantit.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblQuantit.setBounds(228, 245, 71, 26);
		contentPane.add(lblQuantit);
		
		JSpinner quantitaSpin = new JSpinner();
		quantitaSpin.setBackground(Color.WHITE);
		quantitaSpin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		quantitaSpin.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		quantitaSpin.setBounds(309, 245, 45, 26);
		contentPane.add(quantitaSpin);
		
		JLabel lblReparto = new JLabel("Reparto:");
		lblReparto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReparto.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblReparto.setBounds(54, 319, 80, 26);
		contentPane.add(lblReparto);
		
		JComboBox<String> repartoCombo = new JComboBox<String>();
		repartoCombo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		repartoCombo.setMaximumRowCount(5);
		repartoCombo.setBackground(Color.WHITE);
		repartoCombo.setBounds(144, 319, 155, 26);
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
				
				if((idField.getText().isEmpty()) || (nomeField.getText().isEmpty()) || (coloreField.getText().isEmpty()) || (prezzo == 0) || (qta == 0)) {
					errore.setText("*Tutti i campi devono essere valorizzati correttamente!");;
				}
				else {
					errore.setVisible(false);
					
					Articolo artnuovo = new Articolo();
					artnuovo.setIdarticolo(idField.getText());
					artnuovo.setNome(nomeField.getText());
					artnuovo.setDescrizione(descrizioneCombo.getSelectedItem().toString());
					artnuovo.setPrezzo(prezzo);
					artnuovo.setTaglia(tagliaCombo.getSelectedItem().toString());
					artnuovo.setColore(coloreField.getText());
					artnuovo.setReparto(repartoCombo.getSelectedItem().toString());
					artnuovo.setQuantita(qta);
					
					if(c.insertArticolo(artnuovo)) {
						new OKpopup().setVisible(true);
					}
					else {
						new Errore().setVisible(true);
					}
				}
			}
		});
		btnAggiungi.setBounds(490, 404, 150, 35);
		contentPane.add(btnAggiungi);
	}
}
