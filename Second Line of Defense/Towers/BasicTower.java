package Towers;

import javax.swing.ImageIcon;

public class BasicTower {
	
	ImageIcon towerPicture;
	
	public BasicTower() {
		towerPicture = new ImageIcon("Images/Tower.jpg");
	}
	
	public ImageIcon getIcon() {
		return towerPicture;
	}
	
}
