package Player;
public class Player {
  private int health;
  private int DNA;
  
  public Player() {
    health = 100;
    DNA = 100;
  }
  
  public int health() {
    return health;
  }
  
  public void takeDamage(int damage) {
    health -= damage;
  }
  
  public int getDNA() {
	  return DNA;
  }
  
  public void addDNA(int DNA) {
	  this.DNA += DNA;
  }
  
  public boolean spendDNA(int DNA) {
	
	  if (DNA < this.DNA) {
		  this.DNA -= DNA;
		  return true;
	  }
	  
	  return false;
  }
}
