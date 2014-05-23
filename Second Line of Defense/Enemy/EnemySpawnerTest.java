package Enemy;

import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class EnemySpawnerTest extends TestCase {
  
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
    IEnemy enemy = new BasicBacteria();
    spawner.spawnEnemy(enemy);
    spawner.spawnEnemy(enemy);
    spawner.spawnEnemy(enemy);
    assertEquals (3, spawner.enemiesSpawned());
  }
  
  public void testEnemyKilled() {
    EnemySpawner spawner = new EnemySpawner();
    IEnemy enemy = new BasicBacteria();
    spawner.spawnEnemy(enemy);
    spawner.spawnEnemy(enemy);
    spawner.enemyDeath(enemy);
    assertEquals (1, spawner.enemiesSpawned());
  }
  
}
