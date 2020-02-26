package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class OKpopup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static JLabel allert = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OKpopup dialog = new OKpopup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OKpopup() {
		inizializzaPopup();
		setLocationRelativeTo(null);
	}
	
	private void inizializzaPopup() {
		getToolkit().beep();
		setBounds(100, 100, 450, 200);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.GRAY, 3, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OKpopup.class.getResource("/okicon.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 10, 430, 70);
		contentPanel.add(label);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button.setBackground(SystemColor.menu);
		button.setBounds(365, 154, 75, 35);
		contentPanel.add(button);
		
		allert.setHorizontalAlignment(SwingConstants.CENTER);
		allert.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		allert.setBounds(10, 73, 430, 70);
		contentPanel.add(allert);
	}

}
