package Towers;
import junit.framework.TestCase;

public class TowerTest extends TestCase {
	private Tower aTower;
	private Tower anotherTower;
	protected void setUp() throws Exception {		
		super.setUp();		
		aTower = new Tower(254, 115);
		anotherTower = new Tower(50, 115);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testTowerExists(){		
		assertTrue(aTower.isEmpty());
		anotherTower.build();
		assertFalse(anotherTower.isEmpty());
	}
	
	public void testTowerType(){
		aTower.setType("slow");
		assertEquals("slow", aTower.getType());
	}
	public void testEnemyInRange(){
		IEnemy enemy;
		System.out.println("Need enemy class");
		//need enemy class
		//assertTrue(aTower.inRange(enemy)); 
	}
	

}
