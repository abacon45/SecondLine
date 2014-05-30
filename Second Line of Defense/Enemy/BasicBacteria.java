package Enemy;

import GameEngine.GameEngine;

public class BasicBacteria implements IEnemy {
  private boolean alive;
  private int id;
  private int xLocation;
  private int yLocation;
  
  public BasicBacteria(int newID) {
    alive = true;
    id = newID;
  }
  
  private void died() {
	  GameEngine.enemyDied(id);
  }
  
  public boolean isAlive(){
    return alive;
  }
  
  public int ID(){
    return id;
  }
  
  public boolean equals(Object object) {
    if (object instanceof BasicBacteria) {
      return this.id == ((BasicBacteria) object).id;
    }
    return false;
  }
    
  public void setLocation(int xCoordinate, int yCoordinate)
  {
   xLocation = xCoordinate;
   yLocation = yCoordinate;
   if (yLocation > 650) {
	   died();
   }
  }
  
  public int getLocationX()
  {
   return xLocation;
  }
  
  public int getLocationY()
  {
   return yLocation;
  }
}