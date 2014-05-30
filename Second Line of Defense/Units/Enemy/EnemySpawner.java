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
  Integer i;
  HashMap<Integer, IEnemy> enemies = new HashMap<Integer, IEnemy>();
  
  public EnemySpawner() {
    enemiesSpawned = 0;
  } 
  
  public void spawn() {
	if (enemiesSpawned < enemiesTotal) {
		Object[] i = enemies.keySet().toArray();
		spawnEnemy(enemies.get(i[enemiesSpawned]));
	}
  }
  
  public void moveEnemies() {
	  int numberMoved = 0;
	  for (Integer i : enemies.keySet()) {
		  IEnemy enemy = enemies.get(i);
		  enemy.setLocation(enemy.getLocationX(), enemy.getLocationY() + 1);
		  GameEngine.moveEnemy(enemy.getLocationX(), enemy.getLocationY(), numberMoved);
		  numberMoved++;
		  if(numberMoved < enemiesSpawned()){
			  break;
		  }
	  } 
  }
  public int enemiesSpawned() {
    return enemiesSpawned;
  }
  
  public int enemiesLeft() {
	return enemiesLeft;
  }
  
  public void spawnEnemy(IEnemy enemy) {
    enemiesSpawned ++;
    enemy.setLocation(150, 0);
    GameEngine.drawEnemy(enemy.getLocationX(), enemy.getLocationY());

  }
  
  public void enemyDeath(IEnemy enemy) {
    enemies.remove(enemy.ID());
    enemiesSpawned --;
    enemiesLeft--;
  }
  
  public IEnemy getEnemy(int id){
    return enemies.get(id);
  }
  
  public boolean waveCreation() {
    File f = new File("Units/Enemy/enemies.txt");
    try {
      Scanner scanner =  new Scanner(f);
      while (scanner.hasNextLine()){
        String enemyType = scanner.nextLine();
        int    enemyId   = (int) scanner.nextInt();
        scanner.nextLine();
        IEnemy enemy     = enemyCreator(enemyType, enemyId);
        enemies.put(enemy.ID(), enemy);
        enemiesTotal++;
      }
      enemiesLeft = enemiesTotal;
      scanner.close();
    } catch(Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
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