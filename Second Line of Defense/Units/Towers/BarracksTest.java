package Units.Towers;

import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BarracksTest extends TestCase {
  
  public void testTCellsSpawned() {
    Barracks b = new Barracks();
    assertEquals(3, b.cellsActive());
  }
  
  public void testTCellsExist(){
    Barracks b = new Barracks();
    assertNotNull(b.getCell(100));
    assertNotNull(b.getCell(101));
    assertNotNull(b.getCell(102));
    assertEquals(3, b.cellsActive());
  }
  
  public void testRepopulateBetweenWaves() {
    Barracks b = new Barracks();
    b.getCell(100).takeDamage(100);
    b.getCell(101).takeDamage(100);
   // assertEquals(1, b.cellsActive());
    b.repopulate();
    assertEquals(3, b.cellsActive());
  }
}
