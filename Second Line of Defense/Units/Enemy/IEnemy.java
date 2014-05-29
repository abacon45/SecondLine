package Units.Enemy;
import Units.IUnit;

public interface IEnemy extends IUnit {
  public int getLocationX();
  public int getLocationY();
  public boolean isAlive();
}