package Units.Towers;
import javax.swing.ImageIcon;

import GameEngine.GameEngine;
import Units.IUnit;
import Units.Enemy.*;

public class CytotoxicTCell implements IUnit {
  private int id;
  private int xLocation;
  private int yLocation;
  private int health = 100;
  private int baseDamage = 15;
  private boolean alive;
  private GameEngine g;
  private int damageUpgrade;
  
  public CytotoxicTCell(int id) {
    this.id = id;
    alive = true;
    g = GameEngine.getInstance();
    damageUpgrade = 0;
  }
  
  public int ID() {
    return id;
  }
  
  public boolean isAlive(){
   return alive;
  }
  
  public boolean equals(Object object) {
    if (object instanceof CytotoxicTCell) {
      return this.id == ((CytotoxicTCell) object).id;
    }
    return false;
  }
  
  public void setLocation(int xCoordinate, int yCoordinate) {
   xLocation = xCoordinate;
   yLocation = yCoordinate;
  }
  
  public int getLocationX() {
    return xLocation;
  }
  
  public int getLocationY() {
    return yLocation;
  }
  
  public boolean isAdjacent(IEnemy enemy){
    return enemy.getLocationX() > xLocation - 2 && enemy.getLocationX() < xLocation + 2
         && enemy.getLocationY() > yLocation - 2 && enemy.getLocationY() < yLocation + 2;
  }
  
  public int dealDamage(){
    return baseDamage + damageUpgrade;
  }
  
  public void takeDamage(int damage){
    health -= damage;
    System.out.println("Cell: " + health);
    if (this.health <= 0){
      alive = false;
      died();
    }
  }
  
  private void died() {
 g.cellDied(id);
  }
  
  public int checkHealth(){
    return health;
  }

  public void upgradeDamage(){
    damageUpgrade += 5;
  }

  @Override
  public ImageIcon getIcon() {
    // TODO Auto-generated method stub
    return null;
  }
}
