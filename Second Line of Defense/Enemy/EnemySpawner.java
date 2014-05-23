class EnemySpawner {
  int enemiesSpawned;
  
  public EnemySpawner() {
    enemiesSpawned = 0;
  } 
  
  public int enemiesSpawned() {
    return enemiesSpawned;
  }
  
  public void spawnEnemy(IEnemy enemy) {
    enemiesSpawned ++;
  }
  
  public void enemyDeath(IEnemy enemy) {
    enemiesSpawned --;
  }
}