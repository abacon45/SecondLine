package Units.Enemy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import Units.Enemy.*;
import GameEngine.GameEngine;

public class EnemySpawner {
  int enemiesSpawned;
  int enemiesLeft = 0;
  int enemiesTotal = 0;
  boolean completedSpawn = false;;
  Integer i;
  HashMap<Integer, IEnemy> enemies = new HashMap<Integer, IEnemy>();
  
  public EnemySpawner() {
    enemiesSpawned = 0;
  } 

  public void moveEnemies() {
    for (Integer i : enemies.keySet()) {
      IEnemy enemy = enemies.get(i);
      System.out.println(i);
      if (enemy != null) {
        GameEngine.moveEnemy(enemy.getLocationX(), enemy.getLocationY() + 1, enemy);
        if(enemy.ID() < enemiesSpawned()){
          break;
        }
      }
    } 
  }
    
/*  public void spawn() {
    if (enemiesSpawned < enemiesTotal && !completedSpawn) {
      Object[] i = enemies.keySet().toArray();
      spawnEnemy(enemies.get(i[enemiesSpawned]));
    } else {
      completedSpawn = true;
    }
  } */
  
  public int enemiesSpawned() {
    return enemiesSpawned;
  }
  
  public int enemiesLeft() {
    return enemiesLeft;
  }
  
  public void spawn() {   // MORE REFACTORING NEEDS TO BE DONE.. THIS METHOD WILL LIKELY GET FACTORED OUT
      Object[] i = enemies.keySet().toArray();
      spawnEnemyOnMap(enemies.get(i[enemiesSpawned]));
  }
    
  public void spawnEnemyOnMap(IEnemy enemy) {
    enemiesSpawned ++;
    int startLocation = 20;
    enemy.setLocation(startLocation + 5 * enemy.ID(), 0);
    enemies.put(enemy.ID(), enemy);
//    GameEngine.drawEnemy(enemy.getLocationX(), enemy.getLocationY());
  }
  
  private IEnemy createEnemyFromFile(String type, int id) {
    IEnemy enemy;
    if (type.equals("Bacteria")) {
      enemy = new BasicBacteria(id);
    }
    else enemy = null;
    return enemy;
  }  
  
  public void enemyDeath(IEnemy enemy) {
    enemies.remove(enemy.ID());
    enemiesSpawned --;
  }
  
  public IEnemy getEnemy(int id){
    return enemies.get(id);
  }
  
  public HashMap<Integer, IEnemy> waveCreation() {
    File f = new File("Units/Enemy/enemies.txt");
    try {
      Scanner scanner =  new Scanner(f);
      while (scanner.hasNextLine()){
        String enemyType = scanner.nextLine();
        int    enemyId   = (int) scanner.nextInt();
        scanner.nextLine();
        IEnemy enemy     = createEnemyFromFile(enemyType, enemyId);
        enemies.put(enemy.ID(), enemy);
      }
      scanner.close();
    } catch(Exception e) {
      System.out.println(e);
      return null;
    }
    return enemies;
  }
}