package Enemy;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

class EnemySpawner {
  int enemiesSpawned;
  HashMap<Integer, IEnemy> enemies = new HashMap<Integer, IEnemy>();
  
  public EnemySpawner() {
    enemiesSpawned = 0;
  } 
  
  public int enemiesSpawned() {
    return enemiesSpawned;
  }
  
  public void spawnEnemy(IEnemy enemy) {
    enemies.put(enemy.ID(), enemy);
    enemiesSpawned ++;
  }
  
  public void enemyDeath(IEnemy enemy) {
    enemies.remove(enemy.ID());
    enemiesSpawned --;
  }
  
  public IEnemy getEnemy(int id){
    return enemies.get(id);
  }
  
  public HashMap<Integer, IEnemy> waveCreation() {
    File f = new File("Enemy/enemies.txt");
    try {
      Scanner scanner =  new Scanner(f);
      while (scanner.hasNextLine()){
        String enemyType = scanner.nextLine();
        int    enemyId   = (int) scanner.nextInt();
        scanner.nextLine();
        IEnemy enemy     = enemyCreator(enemyType, enemyId);
        enemies.put(enemy.ID(), enemy);
      }
      scanner.close();
    } catch(Exception e) {
      System.out.println(e);
      return null;
    }
    return enemies;
  }
  
  private IEnemy enemyCreator(String type, int id) {
    IEnemy enemy;
    if (type.equals("Bacteria")) {
      enemy = new BasicBacteria(id);
    }
    else enemy = null;
    return enemy;
  }
}