package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class PaginaAmministratore extends JFrame {

	private JPanel contentPane;
	Chiusura c = new Chiusura();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaAmministratore frame = new PaginaAmministratore();
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
	public PaginaAmministratore() {
		setResizable(false);
		setTitle("Pannello di controllo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 500);
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/logo.png")));
		lblNewLabel_1.setBounds(10, 11, 186, 96);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Amministratore");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblNewLabel.setBounds(100, 82, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPannelloDiControllo = new JLabel("Pannello di controllo");
		lblPannelloDiControllo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPannelloDiControllo.setForeground(Color.BLACK);
		lblPannelloDiControllo.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblPannelloDiControllo.setBounds(213, 45, 244, 25);
		contentPane.add(lblPannelloDiControllo);
		
		JButton addbutton = new JButton("Aggiungi articolo");
		addbutton.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/addbutton.png")));
		addbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiArticolo adda = new AggiungiArticolo();
				adda.setVisible(true);
			}
		});
		addbutton.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		addbutton.setBackground(SystemColor.menu);
		addbutton.setBounds(213, 136, 200, 230);
		contentPane.add(addbutton);
		
		JButton closebutton = new JButton("");
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.setVisible(true);
			}
		});
		closebutton.setBorder(BorderFactory.createEmptyBorder());
		closebutton.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/close.png")));
		closebutton.setBackground(Color.WHITE);
		closebutton.setBounds(803, 11, 30, 30);
		contentPane.add(closebutton);
		
		JButton btnModificaArticolo = new JButton("Modifica articolo");
		btnModificaArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModificaArticolo().setVisible(true);
			}
		});
		btnModificaArticolo.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/updatebutton.png")));
		btnModificaArticolo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificaArticolo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificaArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnModificaArticolo.setBackground(SystemColor.menu);
		btnModificaArticolo.setBounds(423, 136, 200, 230);
		contentPane.add(btnModificaArticolo);
		
		JButton btnEliminaArticolo = new JButton("Elimina articolo");
		btnEliminaArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RimuoviArticolo().setVisible(true);
			}
		});
		btnEliminaArticolo.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/removebutton.png")));
		btnEliminaArticolo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminaArticolo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminaArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnEliminaArticolo.setBackground(SystemColor.menu);
		btnEliminaArticolo.setBounds(633, 136, 200, 230);
		contentPane.add(btnEliminaArticolo);
		
		JLabel lblInserireUnNuovo = new JLabel("Inserire un nuovo");
		lblInserireUnNuovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserireUnNuovo.setForeground(Color.BLACK);
		lblInserireUnNuovo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblInserireUnNuovo.setBounds(213, 377, 200, 25);
		contentPane.add(lblInserireUnNuovo);
		
		JLabel lblArticoloNelDatabase = new JLabel("articolo nel database");
		lblArticoloNelDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticoloNelDatabase.setForeground(Color.BLACK);
		lblArticoloNelDatabase.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblArticoloNelDatabase.setBounds(213, 402, 200, 25);
		contentPane.add(lblArticoloNelDatabase);
		
		JLabel lblModificareUnArticolo = new JLabel("Modificare un articolo");
		lblModificareUnArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificareUnArticolo.setForeground(Color.BLACK);
		lblModificareUnArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblModificareUnArticolo.setBounds(423, 377, 200, 25);
		contentPane.add(lblModificareUnArticolo);
		
		JLabel lblGiEsistenteNel = new JLabel("gi\u00E1 esistente nel");
		lblGiEsistenteNel.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiEsistenteNel.setForeground(Color.BLACK);
		lblGiEsistenteNel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblGiEsistenteNel.setBounds(423, 402, 200, 25);
		contentPane.add(lblGiEsistenteNel);
		
		JLabel lblDatabase = new JLabel("database");
		lblDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatabase.setForeground(Color.BLACK);
		lblDatabase.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblDatabase.setBounds(423, 427, 200, 25);
		contentPane.add(lblDatabase);
		
		JLabel lblRimuovereUnArticolo = new JLabel("Rimuovere un articolo");
		lblRimuovereUnArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRimuovereUnArticolo.setForeground(Color.BLACK);
		lblRimuovereUnArticolo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblRimuovereUnArticolo.setBounds(633, 377, 200, 25);
		contentPane.add(lblRimuovereUnArticolo);
		
		JLabel lblDalDatabase = new JLabel("dal database");
		lblDalDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblDalDatabase.setForeground(Color.BLACK);
		lblDalDatabase.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblDalDatabase.setBounds(633, 402, 200, 25);
		contentPane.add(lblDalDatabase);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(PaginaAmministratore.class.getResource("/background2.png")));
		background.setBounds(3, 3, 200, 494);
		contentPane.add(background);
	}
}
