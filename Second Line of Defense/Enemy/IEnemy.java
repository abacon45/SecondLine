package Enemy;

public interface IEnemy {
  public boolean isAlive();
  public int ID();
  public boolean equals(Object object);
  public int getLocationX();
  public int getLocationY();
  public void setLocation(int xCoordinate, int yCoordinate);
}