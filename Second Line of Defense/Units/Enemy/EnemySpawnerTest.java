package Units.Enemy;
import java.util.HashMap;
import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class EnemySpawnerTest extends TestCase {
  final int MAX_ENEMIES = 5;
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testNoEnemiesSpawned() {
    EnemySpawner spawner = new EnemySpawner();
    assertEquals (0, spawner.enemiesSpawned());
  }
  
  public void testMultipleEnemiesSpawned() {
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy = new BasicBacteria(0);
    spawner.spawnEnemyOnMap(enemy);
    spawner.spawnEnemyOnMap(enemy);
    spawner.spawnEnemyOnMap(enemy);
    assertEquals (3, spawner.enemiesSpawned());
  }
  
  public void testEnemyKilled() {
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy = new BasicBacteria(0);
    spawner.spawnEnemyOnMap(enemy);
    spawner.spawnEnemyOnMap(enemy);
    spawner.enemyDeath(enemy);
    assertEquals (1, spawner.enemiesSpawned());
  }
  
  public void testEnemyIsInCollection(){
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy = new BasicBacteria(0);
    spawner.spawnEnemyOnMap(enemy);
    assertEquals(true, spawner.getEnemy(enemy.ID()).isAlive());
  }
  
  public void testMultipleEnemiesInCollection() {
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy0 = new BasicBacteria(0);
    IEnemy enemy1 = new BasicBacteria(1);
    spawner.spawnEnemyOnMap(enemy0);
    spawner.spawnEnemyOnMap(enemy1);
    
    assertEquals(true, spawner.getEnemy(enemy0.ID()).isAlive());
    assertEquals(true, spawner.getEnemy(enemy1.ID()).isAlive());  
  }
  
  public void testDeadEnemiesDeletedFromCollection() {
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy0 = new BasicBacteria(0);
    IEnemy enemy1 = new BasicBacteria(1);
    spawner.spawnEnemyOnMap(enemy0);
    spawner.spawnEnemyOnMap(enemy1);
    spawner.enemyDeath(enemy1);
    
    assertNull (spawner.getEnemy(enemy1.ID()));
  }
  
  public void testEnemyInfoReadFromFile() {
    
    EnemySpawner spawner = new EnemySpawner();
    HashMap<Integer, IEnemy> temp = new HashMap<Integer, IEnemy>();
    for (int i=0; i < MAX_ENEMIES; i++){
      IEnemy enemy = new BasicBacteria(i);
      spawner.spawnEnemyOnMap(enemy);
      temp.put(i, enemy);
    }
    assertEquals(temp, spawner.waveCreation());
  }
}
