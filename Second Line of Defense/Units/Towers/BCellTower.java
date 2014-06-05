package Units.Towers;
import java.awt.Image;

import javax.swing.ImageIcon;

import Units.Enemy.*;

public class BCellTower extends Tower {
  
  ImageIcon towerPicture;
	
  public BCellTower(int id){
    super(id);
    baseDamage = 0;
    towerPicture = new ImageIcon("Images/images-1.jpg");
	Image image = towerPicture.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	towerPicture.setImage(image);
  }
  public void attack(IEnemy enemy){
    enemy.takeDamage(dealDamage());
    enemy.setSlowed(true);
  }
  public ImageIcon getIcon() {
   return towerPicture;
  }
  
}
