package Units.Enemy;

<<<<<<< HEAD
import GameEngine.GameEngine;

=======
>>>>>>> 75ba4bc7437689c6fd7b31d6bbc25004065a50df
public class BasicBacteria implements IEnemy {
  private boolean alive;
  private int id;
  private int xLocation;
  private int yLocation;
  
  public BasicBacteria(int id) {
    alive = true;
    this.id = id;
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
<<<<<<< HEAD
   if (yLocation > 650) {
	   died();
   }
  }
  
  private void died() {
	  GameEngine.enemyDied(id);
=======
>>>>>>> 75ba4bc7437689c6fd7b31d6bbc25004065a50df
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