package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class OKpopup extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		{
			JLabel lblNewLabel = new JLabel("Operazione avvenuta con successo!");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
			lblNewLabel.setBounds(10, 73, 430, 70);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(OKpopup.class.getResource("/okicon.gif")));
			lblNewLabel_1.setBounds(10, 11, 430, 70);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					AggiungiArticolo a = new AggiungiArticolo();
					a.dispose();
				}
			});
			btnNewButton.setBackground(SystemColor.menu);
			btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
			btnNewButton.setBounds(365, 154, 75, 35);
			contentPanel.add(btnNewButton);
		}
	}

}
