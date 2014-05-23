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
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon map = new ImageIcon("Images/GameMap.png");
		Image i = map.getImage().getScaledInstance(480, 778, Image.SCALE_SMOOTH);
		map.setImage(i);
		
		JButton btnNewButton = new JButton("<>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(90, 30, 40, 40);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<>");
		button.setBounds(254, 115, 40, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<>");
		button_1.setBounds(225, 256, 40, 40);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("<>");
		button_2.setBounds(90, 555, 40, 40);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("<>");
		button_3.setBounds(306, 555, 40, 40);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("<>");
		button_4.setBounds(0, 229, 40, 40);
		contentPane.add(button_4);
		lblNewLabel.setIcon(map);
		lblNewLabel.setBounds(0, 0, 480, 778);
		contentPane.add(lblNewLabel);
	}
}
