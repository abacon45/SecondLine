package Enemy;

import junit.framework.TestCase;

public class BasicBacteriaTest extends TestCase {

	BasicBacteria myBacteria;
	protected void setUp() throws Exception {
		super.setUp();
		myBacteria = new BasicBacteria(143);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCoordinates()
	{
		myBacteria.setLocation(50,51);
		assertEquals(50, myBacteria.getLocationX());
		assertEquals(51, myBacteria.getLocationY());
		
	}

}
