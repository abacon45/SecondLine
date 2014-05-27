package Towers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BasicTower {
	
	ImageIcon towerPicture;
	
	public BasicTower() {
		towerPicture = new ImageIcon("Images/Tower.jpg");
		Image tImage = towerPicture.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		towerPicture.setImage(tImage);
	}
	
	public ImageIcon getIcon() {
		return towerPicture;
	}
	
}
