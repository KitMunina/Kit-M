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
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	
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
		setTitle("Kit&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000, 600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.GRAY, 3, true));
		setContentPane(contentPane);
		
		JButton button = new JButton("");
		button.setBounds(960, 11, 30, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		button.setIcon(new ImageIcon(Homepage.class.getResource("/close.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		contentPane.add(button);
		
		JButton loginbutton = new JButton("");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l = new Login();
				l.setVisible(true);
			}
		});
		loginbutton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		loginbutton.setToolTipText("");
		loginbutton.setBounds(920, 63, 30, 30);
		loginbutton.setIcon(new ImageIcon(Homepage.class.getResource("/userlogin.png")));
		loginbutton.setBorder(BorderFactory.createEmptyBorder());
		loginbutton.setBackground(Color.WHITE);
		contentPane.add(loginbutton);
		
		JButton cartbutton = new JButton("");
		cartbutton.setBounds(960, 63, 30, 30);
		cartbutton.setIcon(new ImageIcon(Homepage.class.getResource("/shoppingbagicon.png")));
		cartbutton.setBorder(BorderFactory.createEmptyBorder());
		cartbutton.setBackground(Color.WHITE);
		contentPane.add(cartbutton);
		
		JLabel lblB = new JLabel("");
		lblB.setBounds(13, 11, 977, 46);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setIcon(new ImageIcon(Homepage.class.getResource("/logo_home.png")));
		contentPane.add(lblB);
		
		searchField = new JTextField();
		searchField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchField.setText("");
			}
			
			public void focusLost(FocusEvent e) {
		        searchField.setText("Cerca un prodotto...");
		    }
		});
		searchField.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		searchField.setText("Cerca un prodotto...");
		searchField.setBounds(710, 68, 200, 21);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("T-Shirt & Polo");
		mntmNewMenuItem.setIcon(null);
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmNewMenuItem);
		
		JMenuItem mntmCamicie = new JMenuItem("Camicie");
		mntmCamicie.setIcon(null);
		mntmCamicie.setBackground(Color.WHITE);
		mntmCamicie.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmCamicie);
		
		JMenuItem mntmPantaloni = new JMenuItem("Pantaloni");
		mntmPantaloni.setIcon(null);
		mntmPantaloni.setBackground(Color.WHITE);
		mntmPantaloni.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmPantaloni);
		
		JMenuItem mntmScarpe = new JMenuItem("Scarpe");
		mntmScarpe.setBackground(Color.WHITE);
		mntmScarpe.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmScarpe);
		
		JMenuItem mntmCappotti = new JMenuItem("Cappotti");
		mntmCappotti.setBackground(Color.WHITE);
		mntmCappotti.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmCappotti);
		
		JMenuItem mntmGiubbini = new JMenuItem("Giubbini");
		mntmGiubbini.setBackground(Color.WHITE);
		mntmGiubbini.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmGiubbini);
		
		JMenuItem mntmIntimo = new JMenuItem("Intimo");
		mntmIntimo.setBackground(Color.WHITE);
		mntmIntimo.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmIntimo);
		
		JMenuItem mntmCalzini = new JMenuItem("Calzini");
		mntmCalzini.setBackground(Color.WHITE);
		mntmCalzini.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmCalzini);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mostra tutto");
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnUomo.add(mntmNewMenuItem_1);
		
		JMenu mnDonna = new JMenu("DONNA");
		mnDonna.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		menuBar.add(mnDonna);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("T-Shirt");
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.setSelected(true);
		mntmNewMenuItem_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Camicie");
		mntmNewMenuItem_3.setBackground(Color.WHITE);
		mntmNewMenuItem_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmNewMenuItem_3);
		
		JMenuItem mntmPantaloni_1 = new JMenuItem("Pantaloni");
		mntmPantaloni_1.setBackground(Color.WHITE);
		mntmPantaloni_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmPantaloni_1);
		
		JMenuItem mntmGonne = new JMenuItem("Gonne");
		mntmGonne.setBackground(Color.WHITE);
		mntmGonne.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmGonne);
		
		JMenuItem mntmCappotti_1 = new JMenuItem("Cappotti");
		mntmCappotti_1.setBackground(Color.WHITE);
		mntmCappotti_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmCappotti_1);
		
		JMenuItem mntmCalzini_1 = new JMenuItem("Calzini");
		mntmCalzini_1.setBackground(Color.WHITE);
		mntmCalzini_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmCalzini_1);
		
		JMenuItem mntmScarpe_1 = new JMenuItem("Scarpe e tacchi");
		mntmScarpe_1.setBackground(Color.WHITE);
		mntmScarpe_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmScarpe_1);
		
		JMenuItem mntmIntimo_1 = new JMenuItem("Intimo");
		mntmIntimo_1.setBackground(Color.WHITE);
		mntmIntimo_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmIntimo_1);
		
		JMenuItem mntmMostraTutto = new JMenuItem("Mostra tutto");
		mntmMostraTutto.setBackground(Color.WHITE);
		mntmMostraTutto.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnDonna.add(mntmMostraTutto);
		
		JMenu mnAccessori = new JMenu("ACCESSORI");
		mnAccessori.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		menuBar.add(mnAccessori);
		
		JMenuItem mntmBorseEZaini = new JMenuItem("Borse e zaini");
		mntmBorseEZaini.setBackground(Color.WHITE);
		mntmBorseEZaini.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnAccessori.add(mntmBorseEZaini);
		
		JMenuItem mntmCappelli = new JMenuItem("Cappelli");
		mntmCappelli.setBackground(Color.WHITE);
		mntmCappelli.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnAccessori.add(mntmCappelli);
		
		JMenuItem mntmOrologi = new JMenuItem("Orologi");
		mntmOrologi.setBackground(Color.WHITE);
		mntmOrologi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mnAccessori.add(mntmOrologi);
		
		JLabel lblNewLabel = new JLabel("Esplora il negozio per categoria prodotto:");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNewLabel.setBounds(155, 100, 690, 42);
		contentPane.add(lblNewLabel);
		
		JButton tshirt = new JButton("Parti superiori");
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
		tshirt.setBounds(155, 162, 180, 200);
		contentPane.add(tshirt);
		
		JButton pants = new JButton("Parti inferiori");
		pants.setIcon(new ImageIcon(Homepage.class.getResource("/pantaloni.png")));
		pants.setVerticalTextPosition(SwingConstants.BOTTOM);
		pants.setHorizontalTextPosition(SwingConstants.CENTER);
		pants.setBackground(SystemColor.menu);
		pants.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		pants.setBounds(410, 162, 180, 200);
		contentPane.add(pants);
		
		JButton scarpe = new JButton("Scarpe e calzini");
		scarpe.setIcon(new ImageIcon(Homepage.class.getResource("/scarpe.png")));
		scarpe.setVerticalTextPosition(SwingConstants.BOTTOM);
		scarpe.setHorizontalTextPosition(SwingConstants.CENTER);
		scarpe.setBackground(SystemColor.menu);
		scarpe.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		scarpe.setBounds(665, 162, 180, 200);
		contentPane.add(scarpe);
		
		JButton giacche = new JButton("Soprabiti");
		giacche.setIcon(new ImageIcon(Homepage.class.getResource("/soprabiti.png")));
		giacche.setVerticalTextPosition(SwingConstants.BOTTOM);
		giacche.setHorizontalTextPosition(SwingConstants.CENTER);
		giacche.setBackground(SystemColor.menu);
		giacche.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		giacche.setBounds(155, 373, 180, 200);
		contentPane.add(giacche);
		
		JButton cappelli = new JButton("Copricapi");
		cappelli.setIcon(new ImageIcon(Homepage.class.getResource("/cappelli.png")));
		cappelli.setVerticalTextPosition(SwingConstants.BOTTOM);
		cappelli.setHorizontalTextPosition(SwingConstants.CENTER);
		cappelli.setBackground(SystemColor.menu);
		cappelli.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cappelli.setBounds(410, 373, 180, 200);
		contentPane.add(cappelli);
		
		JButton borse = new JButton("Borse e zaini");
		borse.setIcon(new ImageIcon(Homepage.class.getResource("/borse.png")));
		borse.setVerticalTextPosition(SwingConstants.BOTTOM);
		borse.setHorizontalTextPosition(SwingConstants.CENTER);
		borse.setBackground(SystemColor.menu);
		borse.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		borse.setBounds(665, 373, 180, 200);
		contentPane.add(borse);
	}
}
