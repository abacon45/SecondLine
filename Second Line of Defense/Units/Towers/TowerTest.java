package Units.Towers;
import Units.Enemy.*;
import junit.framework.TestCase;

public class TowerTest extends TestCase {
 private Tower aTower;
 private Tower anotherTower;
 private BasicBacteria[] bacteriaArray;

 protected void setUp() throws Exception {  
   super.setUp();  
   aTower = new Tower(100);
   aTower.setLocation(254, 115);
   anotherTower = new Tower(101);
   anotherTower.setLocation(49, 115);
   bacteriaArray = new BasicBacteria[6];
   for (int i = 0; i < 6; i++)
   {
     bacteriaArray[i] = new BasicBacteria(i+1);
   }
   
 }

 protected void tearDown() throws Exception {
  super.tearDown();
 }
 
 public void testTowerExists() {
   assertEquals(100, aTower.ID());
 }
 
 public void testTowerAtLocation() {
   
 }
 
 public void testEnemyInRange(){ //To do
   BasicBacteria bacteria = new BasicBacteria(123);
   bacteria.setLocation(50, 51);
   assertFalse(aTower.inRange(bacteria));
   
   bacteriaArray[0].setLocation(254, 115);
   bacteriaArray[1].setLocation(274, 135);
   bacteriaArray[2].setLocation(260, 120);
   bacteriaArray[3].setLocation(10, 10);
   bacteriaArray[4].setLocation(100, 118);
   bacteriaArray[5].setLocation(260, 300);
   
   for (int i = 0; i < 3; i++)
   {
     assertTrue(aTower.inRange(bacteriaArray[i]));
   }
   for (int i = 3; i < 6; i++)
   {
     assertFalse(aTower.inRange(bacteriaArray[i]));
   }  
   
 }
}
