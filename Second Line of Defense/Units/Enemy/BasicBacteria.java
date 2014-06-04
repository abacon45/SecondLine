package Units.Enemy;

import GameEngine.GameEngine;

public class BasicBacteria implements IEnemy {
  private boolean alive;
  private int id;
  private int xLocation;
  private int yLocation;
  private int baseDamage = 10;
  private int health = 100;
  private boolean slowed;
  GameEngine g;
  
  public BasicBacteria(int id) {
    alive = true;
    slowed = false;
    this.id = id;
    g = GameEngine.getInstance();
  }
  public boolean isAlive(){
    return alive;
  }
  public int ID(){
    return id;
  }
  
  public boolean getSlowed() {
	  return slowed;
  }
  
  public void setSlowed(boolean boolState) {
	  slowed = boolState;
  }
  
  public boolean equals(Object object) {
    if (object instanceof BasicBacteria) {
      return this.id == ((BasicBacteria) object).id;
    }
    return false;
  }
    
  public void setLocation(int gridX, int gridY)
  {
   xLocation = gridX;
   yLocation = gridY;
   if (yLocation >= 55) {
	   g.reachedHeart();
	   died();  
   }
  }
  
  private void died() {
	  g.enemyDied(id);
  }
  
  public int getLocationX()
  {
   return xLocation;
  }
  
  public int getLocationY()
  {
   return yLocation;
  }
  
  public int dealDamage(){
    return baseDamage;
  }
  
  public void takeDamage(int damage){
    health -= damage;
    System.out.println("Bacteria: " + health);
    if (health <= 0){
      alive = false;
      died();
    }
  }
  
  public int checkHealth(){
    return health;
  }
  
}
