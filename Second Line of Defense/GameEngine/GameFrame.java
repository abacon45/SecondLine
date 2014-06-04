package GameEngine;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import Units.Towers.BasicTower;
import Units.Towers.CytotoxicTCell;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JLayeredPane;


public class GameFrame extends JFrame {
	
	JButton[] TowerLocations = new JButton[6];
	JButton[] MenuButtons = new JButton[4];
	JLabel[] enemies = new JLabel[10];
	LinkedList<JLabel> defense = new LinkedList<JLabel>();
	int enemyCount = 0;
	GameEngine g;
	JLabel dnaLabel;

	private JLayeredPane contentPane;
	private JPanel panel;
	private ImageIcon locationImage;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 800);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon map = new ImageIcon("Images/GameMap.png");
		Image i = map.getImage().getScaledInstance(480, 778, Image.SCALE_SMOOTH);
		map.setImage(i);
		g = GameEngine.getInstance();
		
		locationImage = new ImageIcon("Images/imgres.jpg");
		Image image = locationImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		locationImage.setImage(image);
		
		panel = new JPanel();
		panel.setBounds(6, 650, 474, 100);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		final JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton) {
					g.towerSelected(0);
				}
			}
		});
		btnNewButton.setBounds(6, 6, 90, 89);
		panel.add(btnNewButton);
		MenuButtons[0] = btnNewButton;
		
		final JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					g.towerSelected(0);
				}
			}
		});
		button.setBounds(100, 6, 90, 89);
		panel.add(button);
		MenuButtons[1] = button;
		
		final JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.towerSelected(0);
			}
		});
		button_1.setBounds(194, 6, 90, 89);
		panel.add(button_1);
		MenuButtons[2] = button_1;
		
		final JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.cancelSelected();
			}
		});
		cancelButton.setBounds(378, 6, 90, 89);
		panel.add(cancelButton);
		MenuButtons[3] = cancelButton;

		JButton towerBtn1 = new JButton("");
		towerBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(0);
			}
		});
		towerBtn1.setIcon(locationImage); 
		towerBtn1.setBounds(254, 115, 40, 40);
		contentPane.add(towerBtn1);
		TowerLocations[0] = towerBtn1;
		
		JButton towerBtn2 = new JButton("");
		towerBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(1);
			}
		});
		towerBtn2.setIcon(locationImage);
		towerBtn2.setBounds(225, 256, 40, 40);
		contentPane.add(towerBtn2);
		TowerLocations[1] = towerBtn2;
		
		JButton towerBtn3 = new JButton("");
		towerBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(2);
			}
		});
		towerBtn3.setIcon(locationImage);
		towerBtn3.setBounds(90, 555, 40, 40);
		contentPane.add(towerBtn3);
		TowerLocations[2] = towerBtn3;
		
		JButton towerBtn4 = new JButton("");
		towerBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(3);
			}
		});
		towerBtn4.setIcon(locationImage);
		towerBtn4.setBounds(306, 555, 40, 40);
		contentPane.add(towerBtn4);
		TowerLocations[3] = towerBtn4;
		
		JButton towerBtn5 = new JButton("");
		towerBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(4);
			}
		});
		towerBtn5.setIcon(locationImage);
		towerBtn5.setBounds(0, 229, 40, 40);
		contentPane.add(towerBtn5);
		TowerLocations[4] = towerBtn5;

		JButton towerBtn6 = new JButton("");
		towerBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.locationSelected(5);
			}
		});
		towerBtn6.setIcon(locationImage);
		towerBtn6.setBounds(90, 30, 40, 40);
		contentPane.add(towerBtn6);
		TowerLocations[5] = towerBtn6;
		
		JButton btnStartWave = new JButton("Start Wave");
		btnStartWave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.startWaves();
			}
		});
		
		dnaLabel = new JLabel("DNA: 100");
		dnaLabel.setBounds(0, 0, 61, 16);
		contentPane.add(dnaLabel);
		btnStartWave.setBounds(357, 6, 117, 29);
		contentPane.add(btnStartWave);
		
		lblNewLabel.setIcon(map);
		lblNewLabel.setBounds(0, 0, 480, 778);
		contentPane.add(lblNewLabel);
		
	}
	
	public void updateDNA(int d) {
		dnaLabel.setText("DNA: " + d);
	}
	
	public void setPanelVisible(boolean visible) {
		panel.setVisible(visible);
	}
	
	
	public void setTowerForLocation(BasicTower b, int activeLocation) {
		TowerLocations[activeLocation].setIcon(b.getIcon());
	}
	
	public void drawEnemy(int x, int y){
		JLabel enemy = new JLabel();
		enemy.setBounds(x * 20, y * 20, 20, 20);
		enemy.setVisible(true);
		enemy.setIcon(locationImage);
		enemies[enemyCount] = enemy;
		enemyCount++;
	    contentPane.add(enemy, new Integer(10));
		contentPane.validate();
		contentPane.repaint();
	}
	public void moveEnemy(int x, int y, int enemy){
		JLabel enemyLabel = enemies[enemy];
		enemyLabel.setBounds(x * 10, y * 12, 20, 20);
		contentPane.add(enemyLabel);
		contentPane.validate();
		contentPane.repaint();
		contentPane.paintImmediately(contentPane.getBounds());
	}
	
	public void removeEnemyLabel(int enemyID) {
		JLabel enemyLabel = enemies[enemyID];
		enemyLabel.setVisible(false);
		contentPane.validate();
		contentPane.repaint();
		contentPane.paintImmediately(contentPane.getBounds());
		contentPane.remove(enemyLabel);
		enemyCount--;	
	}
	
	public void removeCellLabel(int cellID) {
		JLabel dLabel = defense.get(cellID);
		dLabel.setVisible(false);
		contentPane.validate();
		contentPane.repaint();
		contentPane.paintImmediately(contentPane.getBounds());
		contentPane.remove(dLabel);	
	}
	
	public void clearDefense() {
		defense = new LinkedList<JLabel>();
	}
	
	public void CytotoxicTCellCell(LinkedList<CytotoxicTCell> tCells){
		int count = 0;
		for(int i = 0; i < tCells.size(); i++) {
			JLabel dLabel = new JLabel();
			ImageIcon temp = new ImageIcon("Images/happy-white-blood-cell.jpg");
			Image image = temp.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			temp.setImage(image);
			dLabel.setIcon(temp);
			dLabel.setVisible(true);
			dLabel.setBounds((tCells.get(count).getLocationX()) * 10, (tCells.get(count).getLocationY()) *12, 20, 20);
			defense.add(dLabel);
			contentPane.add(dLabel, new Integer (10));
			count++;
			contentPane.validate();
			contentPane.repaint();
			contentPane.paintImmediately(contentPane.getBounds());
		}

	}
}
