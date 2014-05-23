import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


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
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon map = new ImageIcon("Images/GameMap.png");
		Image i = map.getImage().getScaledInstance(480, 778, Image.SCALE_SMOOTH);
		map.setImage(i);
		lblNewLabel.setIcon(map);
		lblNewLabel.setBounds(0, 0, 480, 778);
		contentPane.add(lblNewLabel);
	}

}
