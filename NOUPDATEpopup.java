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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NOUPDATEpopup extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NOUPDATEpopup dialog = new NOUPDATEpopup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NOUPDATEpopup() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 200);
		setUndecorated(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.GRAY, 3, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NOUPDATEpopup.class.getResource("/noupdate.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 430, 70);
		contentPanel.add(label);
		
		JLabel lblNessunaModifica = new JLabel("Nessuna modifica \u00E9 stata apportata");
		lblNessunaModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblNessunaModifica.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNessunaModifica.setBounds(10, 73, 430, 70);
		contentPanel.add(lblNessunaModifica);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModificaArticolo ma = new ModificaArticolo();
				ma.dispose();
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button.setBackground(SystemColor.menu);
		button.setBounds(365, 154, 75, 35);
		contentPanel.add(button);
	}
}
