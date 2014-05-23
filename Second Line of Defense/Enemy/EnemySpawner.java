import java.util.HashMap;

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
}