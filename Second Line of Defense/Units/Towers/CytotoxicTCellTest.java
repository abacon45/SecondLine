package Units.Towers;

import junit.framework.TestCase;
import Units.Enemy.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CytotoxicTCellTest extends TestCase {
  
  public void testTCellExists() {
    CytotoxicTCell tCell = new CytotoxicTCell(0);
    assertEquals(0, tCell.ID());
  }
  
  public void testCellLocation() {
    CytotoxicTCell tCell = new CytotoxicTCell(0);
    tCell.setLocation(1, 2);
    assertEquals(1, tCell.getLocationX());
    assertEquals(2, tCell.getLocationY());
  }
  
  public void testAdjacentEnemy(){
    CytotoxicTCell tCell = new CytotoxicTCell(0);
    tCell.setLocation(1, 2);
    BasicBacteria bad1 = new BasicBacteria(1);
    bad1.setLocation(0,1);
    BasicBacteria bad2 = new BasicBacteria(2);
    bad2.setLocation(1,1);
    BasicBacteria bad3 = new BasicBacteria(3);
    bad3.setLocation(2, 1);
    BasicBacteria bad4 = new BasicBacteria(4);
    bad4.setLocation(0, 2);
    BasicBacteria bad5 = new BasicBacteria(5);
    bad5.setLocation(2, 2);
    BasicBacteria bad6 = new BasicBacteria(6);
    bad6.setLocation(0, 3);
    BasicBacteria bad7 = new BasicBacteria(7);
    bad7.setLocation(1, 3);
    BasicBacteria bad8 = new BasicBacteria(8);
    bad8.setLocation(2, 3);
    BasicBacteria bad9 = new BasicBacteria(9);
    bad9.setLocation(3, 3);
    
    assertTrue(tCell.isAdjacent(bad1));
    assertTrue(tCell.isAdjacent(bad2));
    assertTrue(tCell.isAdjacent(bad3));
    assertTrue(tCell.isAdjacent(bad4));
    assertTrue(tCell.isAdjacent(bad5));
    assertTrue(tCell.isAdjacent(bad6));
    assertTrue(tCell.isAdjacent(bad7));
    assertTrue(tCell.isAdjacent(bad8));
    assertFalse(tCell.isAdjacent(bad9));
  }
  
  public void testDealDamage(){
    CytotoxicTCell tCell = new CytotoxicTCell(0);
    tCell.setLocation(1, 2);
    BasicBacteria bad1 = new BasicBacteria(1);
    bad1.setLocation(0,1);
    bad1.takeDamage(tCell.dealDamage());
    assertEquals(bad1.checkHealth(), 85);
  }
  public void testIsDead(){
    CytotoxicTCell tCell = new CytotoxicTCell(0);
    tCell.setLocation(1, 2);
    BasicBacteria bad1 = new BasicBacteria(1);
    bad1.setLocation(0,1);
    for (int i = 0; i < 10; i++){      
      bad1.takeDamage(tCell.dealDamage());
    }
    assertFalse(bad1.isAlive());
  }
}
