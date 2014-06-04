package Units.Towers;
import Units.Enemy.*;

public class BCellTower extends Tower {
  
  public BCellTower(int id){
    super(id);
    baseDamage = 0;
  }
  public void attack(IEnemy enemy){
    enemy.takeDamage(dealDamage());
    enemy.setSlowed(true);
  }
  
}
