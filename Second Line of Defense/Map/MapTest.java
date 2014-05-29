import junit.framework.TestCase;
import java.util.ArrayList;
import Units.Enemy.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class MapTest extends TestCase {
  int w = 40;
  int h = 60;
  
  public void testMapExists() {
    Map map = new Map(w, h);
    assertNotNull(map);
  }
  
  public void testHeartLocation() {
    Map map = new Map(w, h);
    int[] i = new int[] {w / 2, h - 5};
    assertEquals(map.heartLocation()[0], i[0]); 
    assertEquals(map.heartLocation()[1], i[1]);
  }
  
  public void testSingleEntryPoint() {
    Map map = new Map(w, h);
    map.initEntryPoint(w, h);
    assertEquals(map.getEntryPoints().get(0).getX(), w);
    assertEquals(map.getEntryPoints().get(0).getY(), h);
  }
  
  public void testSpotEmpty() {
    Map map = new Map(w, h);
    assertTrue(map.isEmpty(0,0));
  }
  
  public void testOccupiesLocation() {
    Map map = new Map(w, h);
    BasicBacteria b = new BasicBacteria(0);
    map.placeUnit(0, 0, b);
    assertFalse(map.isEmpty(0,0));
  }
  
  public void testMoveUnit() {
    Map map = new Map(w, h);
    BasicBacteria b = new BasicBacteria(0);
    map.placeUnit(0, 0, b);
    assertEquals(0, b.getLocationX());
    assertEquals(0, b.getLocationY());
    map.placeUnit(1,1,b);
    assertEquals(1, b.getLocationX());
    assertEquals(1, b.getLocationY());
  }
}
