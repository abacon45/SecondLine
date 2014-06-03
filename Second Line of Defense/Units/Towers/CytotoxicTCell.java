package Units.Towers;
import Units.IUnit;
import Units.Enemy.*;

public class CytotoxicTCell implements IUnit {
  private int id;
  private int xLocation;
  private int yLocation;
  private int health = 100;
  private static int baseDamage = 15;
  
  public CytotoxicTCell(int id) {
    this.id = id;
  }
  
  public int ID() {
    return id;
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
    return baseDamage;
  }
  
  public void takeDamage(int damage){
    health -= damage;
  }
  
  public int checkHealth(){
    return health;
  }
  
  public boolean isAlive() {
    return health > 0;
  }
}
