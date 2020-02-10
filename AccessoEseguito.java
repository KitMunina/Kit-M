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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AccessoEseguito extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel ciao = new JLabel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AccessoEseguito dialog = new AccessoEseguito();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AccessoEseguito() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 200);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.GRAY, 3, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ciao.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		ciao.setHorizontalAlignment(SwingConstants.CENTER);
		ciao.setBounds(10, 79, 430, 70);
		contentPanel.add(ciao);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AccessoEseguito.class.getResource("/okicon.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 430, 70);
		contentPanel.add(label);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(SystemColor.menu);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnOk.setBounds(370, 160, 70, 29);
		contentPanel.add(btnOk);
	}
}
