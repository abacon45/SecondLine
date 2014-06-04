package Units.Towers;

import Units.Enemy.*;
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BCellTowerTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testZeroDamageDealt() {
    BCellTower b = new BCellTower(300);
    BasicBacteria badboy = new BasicBacteria(1);
    badboy.takeDamage(b.dealDamage());
    assertEquals(100, badboy.checkHealth());
  }
  
  public void testSlowed(){
    BCellTower b = new BCellTower(300);
    BasicBacteria badboy = new BasicBacteria(1);
    badboy.takeDamage(b.dealDamage());
    badboy.setSlowed(true);
    assertTrue(badboy.getSlowed());
  }
  public void testAttack(){
    BCellTower b = new BCellTower(300);
    BasicBacteria badboy = new BasicBacteria(1);
    b.attack(badboy);
    assertEquals(100, badboy.checkHealth());
  }
}
