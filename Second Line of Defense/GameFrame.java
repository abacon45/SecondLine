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

		JButton towerBtn1 = new JButton("");
		towerBtn1.setIcon(towerImage); 
		towerBtn1.setBounds(254, 115, 40, 40);
		contentPane.add(towerBtn1);
		
		JButton towerBtn2 = new JButton("");
		towerBtn2.setIcon(towerImage);
		towerBtn2.setBounds(225, 256, 40, 40);
		contentPane.add(towerBtn2);
		
		JButton towerBtn3 = new JButton("");
		towerBtn3.setIcon(towerImage);
		towerBtn3.setBounds(90, 555, 40, 40);
		contentPane.add(towerBtn3);
		
		JButton towerBtn4 = new JButton("");
		towerBtn4.setIcon(towerImage);
		towerBtn4.setBounds(306, 555, 40, 40);
		contentPane.add(towerBtn4);
		
		JButton towerBtn5 = new JButton("");
		towerBtn5.setIcon(towerImage);
		towerBtn5.setBounds(0, 229, 40, 40);
		contentPane.add(towerBtn5);

		JButton towerBtn6 = new JButton("");
		towerBtn6.setIcon(towerImage);
		towerBtn6.setBounds(90, 30, 40, 40);
		contentPane.add(towerBtn6);

		lblNewLabel.setIcon(map);
		lblNewLabel.setBounds(0, 0, 480, 778);
		contentPane.add(lblNewLabel);
	}
}
