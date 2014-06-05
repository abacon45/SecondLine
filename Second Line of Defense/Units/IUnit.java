package Units;

import java.awt.Image;

import javax.swing.ImageIcon;

public interface IUnit {
  public int ID();
  public boolean equals(Object object);
  public void setLocation(int x, int y);
  public ImageIcon getIcon();
//  public void takeDamage(int damage);
//  public int dealDamage();
//  public int checkHealth();
}