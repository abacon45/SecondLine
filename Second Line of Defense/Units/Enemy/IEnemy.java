package Units.Enemy;
import Units.IUnit;

public interface IEnemy extends IUnit {
  public int ID();
  public boolean equals(Object object);
  public int getLocationX();
  public int getLocationY();
  public void setLocation(int xCoordinate, int yCoordinate);
  public boolean isAlive();
public void takeDamage(int dealDamage);
public int dealDamage();
}