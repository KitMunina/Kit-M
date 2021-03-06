package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Errore extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static JLabel errore = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Errore dialog = new Errore();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Errore() {
		inizializzaPopup();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaPopup() {
		getToolkit().beep();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 200);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.GRAY, 3, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button.setBackground(SystemColor.menu);
		button.setBounds(365, 154, 75, 35);
		contentPanel.add(button);
		
		errore.setHorizontalAlignment(SwingConstants.CENTER);
		errore.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		errore.setBounds(10, 73, 430, 70);
		contentPanel.add(errore);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Errore.class.getResource("/unknownerror.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 430, 70);
		contentPanel.add(label);
	}
}
