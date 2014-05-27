import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon map = new ImageIcon("Images/GameMap.png");
		Image i = map.getImage().getScaledInstance(480, 778, Image.SCALE_SMOOTH);
		map.setImage(i);
		
		ImageIcon towerImage = new ImageIcon("Images/Tower.jpg");
		Image image = towerImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		towerImage.setImage(image);
		
		final JPanel panel = new JPanel();
		panel.setBounds(6, 650, 474, 100);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		final JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton) {
					panel.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(6, 6, 90, 89);
		panel.add(btnNewButton);
		
		final JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					panel.setVisible(false);
				}
			}
		});
		button.setBounds(100, 6, 90, 89);
		panel.add(button);
		
		final JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button_1) {
					panel.setVisible(false);
				}
			}
		});
		button_1.setBounds(194, 6, 90, 89);
		panel.add(button_1);
		
		final JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == cancelButton) {
					panel.setVisible(false);
				}
			}
		});
		cancelButton.setBounds(378, 6, 90, 89);
		panel.add(cancelButton);

		final JButton towerBtn1 = new JButton("");
		towerBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn1) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn1.setIcon(towerImage); 
		towerBtn1.setBounds(254, 115, 40, 40);
		contentPane.add(towerBtn1);
		
		final JButton towerBtn2 = new JButton("");
		towerBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn2) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn2.setIcon(towerImage);
		towerBtn2.setBounds(225, 256, 40, 40);
		contentPane.add(towerBtn2);
		
		final JButton towerBtn3 = new JButton("");
		towerBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn3) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn3.setIcon(towerImage);
		towerBtn3.setBounds(90, 555, 40, 40);
		contentPane.add(towerBtn3);
		
		final JButton towerBtn4 = new JButton("");
		towerBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn4) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn4.setIcon(towerImage);
		towerBtn4.setBounds(306, 555, 40, 40);
		contentPane.add(towerBtn4);
		
		final JButton towerBtn5 = new JButton("");
		towerBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn5) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn5.setIcon(towerImage);
		towerBtn5.setBounds(0, 229, 40, 40);
		contentPane.add(towerBtn5);

		final JButton towerBtn6 = new JButton("");
		towerBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == towerBtn6) {
					panel.setVisible(true);
				}
			}
		});
		towerBtn6.setIcon(towerImage);
		towerBtn6.setBounds(90, 30, 40, 40);
		contentPane.add(towerBtn6);

		lblNewLabel.setIcon(map);
		lblNewLabel.setBounds(0, 0, 480, 778);
		contentPane.add(lblNewLabel);
	}
}
