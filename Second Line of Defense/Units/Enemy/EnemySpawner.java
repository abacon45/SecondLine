package Units.Enemy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import Units.Enemy.*;
import Units.Towers.CytotoxicTCell;
import GameEngine.GameEngine;

public class EnemySpawner {
  int enemiesSpawned;
  int enemiesLeft = 0;
  int enemiesTotal = 0;
  boolean completedSpawn = false;;
  Integer i;
  HashMap<Integer, IEnemy> enemies = new HashMap<Integer, IEnemy>();
  LinkedList<IEnemy> aliveEnemies = new LinkedList<IEnemy>();
  
  public EnemySpawner() {
    enemiesSpawned = 0;
  } 

  public void moveEnemies() {
	  for (int i = 0; i < aliveEnemies.size(); i++) {
		  IEnemy enemy = aliveEnemies.get(i);
		  GameEngine.moveEnemy(enemy.getLocationX(), enemy.getLocationY() + 1, enemy);
		if(enemy.ID() == enemiesSpawned() - 1){
			break;
		}
	  }
  }
    
  public void spawn() {
    if (enemiesSpawned < enemiesTotal && !completedSpawn) {
      Object[] i = enemies.keySet().toArray();
      spawnEnemyOnMap(enemies.get(i[enemiesSpawned]));
    } else {
      completedSpawn = true;
    }
  } 
  
  public int enemiesTotal() {
	return enemiesTotal;
  }
  
  public int enemiesSpawned() {
    return enemiesSpawned;
  }
  
  public int enemiesLeft() {
    return enemiesLeft;
  }
    
  public void spawnEnemyOnMap(IEnemy enemy) {
    enemiesSpawned ++;
    int startLocation = 17;
    enemy.setLocation(startLocation, 0);
    GameEngine.drawEnemy(enemy.getLocationX(), enemy.getLocationY());
    aliveEnemies.add(enemy);
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
	aliveEnemies.remove(enemy);
    enemies.remove(enemy.ID());
    enemiesLeft --;
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
        enemiesTotal++;
      }
      enemiesLeft = enemiesTotal;
      scanner.close();
    } catch(Exception e) {
      System.out.println(e);
      return null;
    }
    return enemies;
  }
  
  public void checkCombat(LinkedList<CytotoxicTCell> defense){
	  for (CytotoxicTCell cell: defense){
		  for (int i = 0; i < aliveEnemies.size(); i++) {
			  IEnemy enemy = aliveEnemies.get(i);
			  if (cell.isAdjacent(enemy)){
			    GameEngine.startCombat(enemy, cell);
			  }
		  }
	  }
  }
  
}
