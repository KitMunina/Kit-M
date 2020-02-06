package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Chiusura extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Chiusura dialog = new Chiusura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Chiusura() {
		setUndecorated(true);
		setBounds(100, 100, 450, 220);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.GRAY, 3, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sei sicuro di voler uscire dal programma?");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 74, 430, 72);
		contentPanel.add(lblNewLabel);
		
		JButton btnSi = new JButton("No");
		btnSi.setBackground(SystemColor.menu);
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSi.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnSi.setBounds(230, 157, 89, 35);
		contentPanel.add(btnSi);
		
		JButton button = new JButton("Si");
		button.setBackground(SystemColor.menu);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button.setBounds(131, 157, 89, 35);
		contentPanel.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Chiusura.class.getResource("/chiusurapopup.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 430, 65);
		contentPanel.add(lblNewLabel_1);
	}
}
