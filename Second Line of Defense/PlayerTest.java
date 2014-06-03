import junit.framework.TestCase;
import Units.Enemy.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PlayerTest extends TestCase {
  
  public void testPlayerExists() {
    Player player1 = new Player();
    assertEquals(100, player1.health());
  }
  
  public void testPlayerTakesDamage() {
    Player player1 = new Player();
    BasicBacteria b = new BasicBacteria(1);
    player1.takeDamage(b.dealDamage() / 2);
    assertEquals(95, player1.health());
  }
  
    
  
}