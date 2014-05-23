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


public class StartMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtSecondLineOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
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
	public StartMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Encyclopedia");
		btnNewButton.setBounds(201, 299, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Options");
		btnNewButton_1.setBounds(201, 258, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load");
		btnNewButton_2.setBounds(201, 217, 117, 29);
		contentPane.add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_3) {
					dispose();
					GameFrame g = new GameFrame();
					g.setVisible(true);
				}
			}
		});
		btnNewButton_3.setBounds(201, 177, 117, 29);
		contentPane.add(btnNewButton_3);
		
		txtSecondLineOf = new JTextField();
		txtSecondLineOf.setText("Second Line of Defense");
		txtSecondLineOf.setBounds(176, 62, 161, 28);
		contentPane.add(txtSecondLineOf);
		txtSecondLineOf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 500, 372);
		lblNewLabel.setIcon(new ImageIcon("/Users/matthewkakavas/git/SecondLine/Second Line of Defense/o-MULTIPLE-SCLEROSIS-TREATMENT-IMMUNE-SYSTEM-facebook.jpg"));
		contentPane.add(lblNewLabel);
	}
}
