public class Player {
  private int health;
  
  public Player() {
    health = 100;
  }
  
  public int health() {
    return health;
  }
  
  public void takeDamage(int damage) {
    health -= damage;
  }
}
