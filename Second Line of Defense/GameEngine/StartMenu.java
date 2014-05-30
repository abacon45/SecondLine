package GameEngine;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class StartMenu extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public StartMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblSecondLineOf = new JLabel("Second Line of Defense");
		lblSecondLineOf.setFont(new Font("Helvetica Neue", Font.PLAIN, 26));
		lblSecondLineOf.setForeground(Color.WHITE);
		lblSecondLineOf.setBounds(110, 0, 294, 61);
		contentPane.add(lblSecondLineOf);
		
		final JButton btnNewButton = new JButton("Encyclopedia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameEngine.startMenuButtonPressed(3);
			}
		});
		btnNewButton.setBounds(184, 700, 117, 29);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Options");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_1) {
					GameEngine.startMenuButtonPressed(2);
				}
			}
		});
		btnNewButton_1.setBounds(184, 659, 117, 29);
		contentPane.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("Load");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_2) {
					GameEngine.startMenuButtonPressed(1);
				}
			}
		});
		btnNewButton_2.setBounds(184, 618, 117, 29);
		contentPane.add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameEngine.startMenuButtonPressed(0);
			}
		});
		btnNewButton_3.setBounds(184, 577, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 480, 800);
		lblNewLabel.setIcon(new ImageIcon("Images/o-MULTIPLE-SCLEROSIS-TREATMENT-IMMUNE-SYSTEM-facebook.jpg"));
		contentPane.add(lblNewLabel);
	}
}
