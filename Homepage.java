
package main;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;

public class Homepage extends JFrame {
	
	static boolean loginstatuscustomer = false;
	static boolean loginstatusadmin = false;
	private JPanel contentPane;
	static JLabel username = new JLabel("");
	static JButton cartbutton = new JButton("");
	static JButton loginbutton = new JButton("");
	static JButton adminlogin = new JButton("");
	static Cliente cliente = null;
	static Carrello carrello = null;
	Controller ctrl = new Controller();
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		inizializzaFrame();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaFrame() {
		setTitle("Kit&M");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		
		JButton closebutton = new JButton("");
		closebutton.setBounds(960, 11, 30, 30);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Chiusura c = new Chiusura();
				c.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		closebutton.setIcon(new ImageIcon(Homepage.class.getResource("/close.png")));
		closebutton.setBorder(BorderFactory.createEmptyBorder());
		closebutton.setBackground(Color.WHITE);
		contentPane.add(closebutton);
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!loginstatuscustomer) {
					LoginCliente lg = new LoginCliente();
					lg.setVisible(true);
				}
				else {
					MioAccount account = new MioAccount();
					account.setVisible(true);
				}
			}
		});
		loginbutton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		loginbutton.setToolTipText("Accedi");
		loginbutton.setBounds(840, 63, 30, 30);
		loginbutton.setIcon(new ImageIcon(Homepage.class.getResource("/loginicon.png")));
		loginbutton.setBorder(BorderFactory.createEmptyBorder());
		loginbutton.setBackground(Color.WHITE);
		contentPane.add(loginbutton);
		
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		username.setBounds(800, 100, 108, 14);
		contentPane.add(username);
		cartbutton.setEnabled(false);
		cartbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((cliente != null) && (carrello != null)) {
					VisualizzaCarrello vc = new VisualizzaCarrello();
					vc.setVisible(true);
				}
				else {
					Errore err = new Errore();
					Errore.errore.setText("Devi prima effettuare l'accesso!");
					err.setVisible(true);
				}
			}
		});
		cartbutton.setToolTipText("Carrello");
		cartbutton.setBounds(900, 63, 30, 30);
		cartbutton.setIcon(new ImageIcon(Homepage.class.getResource("/carticon.png")));
		cartbutton.setBorder(BorderFactory.createEmptyBorder());
		cartbutton.setBackground(Color.WHITE);
		contentPane.add(cartbutton);
		
		JLabel lblB = new JLabel("");
		lblB.setBounds(10, 12, 980, 46);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setIcon(new ImageIcon(Homepage.class.getResource("/logo_home.png")));
		contentPane.add(lblB);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(13, 68, 255, 21);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		menuBar.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		contentPane.add(menuBar);
		
		JMenu mnUomo = new JMenu("UOMO");
		mnUomo.setBackground(Color.WHITE);
		mnUomo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		menuBar.add(mnUomo);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Vai al reparto maschile");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepartoMaschile rm = new RepartoMaschile();
				rm.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmNewMenuItem_1);
		
		JMenu mnDonna = new JMenu("DONNA");
		mnDonna.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		menuBar.add(mnDonna);
		
		JMenuItem mntmMostraTutto = new JMenuItem("Vai al reparto femminle");
		mntmMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepartoFemminile rf = new RepartoFemminile();
				rf.setVisible(true);
			}
		});
		mntmMostraTutto.setBackground(Color.WHITE);
		mntmMostraTutto.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmMostraTutto);
		
		JLabel lblNewLabel = new JLabel("Esplora il negozio per categoria prodotto:");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 100, 980, 42);
		contentPane.add(lblNewLabel);
		
		adminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!loginstatusadmin) {
					dispose();
					LoginAdmin la = new LoginAdmin();
					la.setVisible(true);
				}
				else {
					AccessoEseguito ac = new AccessoEseguito();
					ac.setVisible(true);
				}
			}
		});
		adminlogin.setIcon(new ImageIcon(Homepage.class.getResource("/database.png")));
		adminlogin.setToolTipText("Pannello di controllo amministratore");
		adminlogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		adminlogin.setBorder(BorderFactory.createEmptyBorder());
		adminlogin.setBackground(Color.WHITE);
		adminlogin.setBounds(960, 63, 30, 30);
		contentPane.add(adminlogin);
		
		JButton tshirt = new JButton("Parti superiori");
		tshirt.setBounds(140, 153, 180, 200);
		contentPane.add(tshirt);
		tshirt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PartiSuperiori ps = new PartiSuperiori();
				ps.setVisible(true);
			}
		});
		tshirt.setIcon(new ImageIcon(Homepage.class.getResource("/tshirt.png")));
		tshirt.setVerticalTextPosition(SwingConstants.BOTTOM);
		tshirt.setHorizontalTextPosition(SwingConstants.CENTER);
		tshirt.setBackground(SystemColor.menu);
		tshirt.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		JButton pants = new JButton("Parti inferiori");
		pants.setBounds(410, 153, 180, 200);
		contentPane.add(pants);
		pants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PartiInferiori pi = new PartiInferiori();
				pi.setVisible(true);
			}
		});
		pants.setIcon(new ImageIcon(Homepage.class.getResource("/pantaloni.png")));
		pants.setVerticalTextPosition(SwingConstants.BOTTOM);
		pants.setHorizontalTextPosition(SwingConstants.CENTER);
		pants.setBackground(SystemColor.menu);
		pants.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		JButton scarpe = new JButton("Scarpe e calzini");
		scarpe.setBounds(680, 153, 180, 200);
		contentPane.add(scarpe);
		scarpe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScarpeCalzini sc = new ScarpeCalzini();
				sc.setVisible(true);
			}
		});
		scarpe.setIcon(new ImageIcon(Homepage.class.getResource("/scarpe.png")));
		scarpe.setVerticalTextPosition(SwingConstants.BOTTOM);
		scarpe.setHorizontalTextPosition(SwingConstants.CENTER);
		scarpe.setBackground(SystemColor.menu);
		scarpe.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		JButton giacche = new JButton("Soprabiti");
		giacche.setBounds(140, 377, 180, 200);
		contentPane.add(giacche);
		giacche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Soprabiti s = new Soprabiti();
				s.setVisible(true);
			}
		});
		giacche.setIcon(new ImageIcon(Homepage.class.getResource("/soprabiti.png")));
		giacche.setVerticalTextPosition(SwingConstants.BOTTOM);
		giacche.setHorizontalTextPosition(SwingConstants.CENTER);
		giacche.setBackground(SystemColor.menu);
		giacche.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		JButton cappelli = new JButton("Intimo");
		cappelli.setBounds(410, 377, 180, 200);
		contentPane.add(cappelli);
		cappelli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Intimo cap = new Intimo();
				cap.setVisible(true);
			}
		});
		cappelli.setIcon(new ImageIcon(Homepage.class.getResource("/intimo.png")));
		cappelli.setVerticalTextPosition(SwingConstants.BOTTOM);
		cappelli.setHorizontalTextPosition(SwingConstants.CENTER);
		cappelli.setBackground(SystemColor.menu);
		cappelli.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		JButton borse = new JButton("Accessori");
		borse.setBounds(680, 377, 180, 200);
		contentPane.add(borse);
		borse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accessori bz = new Accessori();
				bz.setVisible(true);
			}
		});
		borse.setIcon(new ImageIcon(Homepage.class.getResource("/accessori.png")));
		borse.setVerticalTextPosition(SwingConstants.BOTTOM);
		borse.setHorizontalTextPosition(SwingConstants.CENTER);
		borse.setBackground(SystemColor.menu);
		borse.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	}
}