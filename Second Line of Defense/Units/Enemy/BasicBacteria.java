package Units.Enemy;

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