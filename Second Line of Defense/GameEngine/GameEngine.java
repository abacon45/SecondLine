package GameEngine;
import java.awt.EventQueue;

import Map.Map;
import Units.Towers.*;
import Units.Enemy.*;


public class GameEngine {
	
	static StartMenu frame;
	static GameFrame gFrame;
	static OptionsFrame oFrame;
	static EncyclopediaFrame eFrame;
	static EnemySpawner eSpawner;
	static int activeLocation;
	static Map m = new Map(40,60);
	static int heartHealth;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void startMenuButtonPressed(int button) {
		switch (button) {
			case 0:
				frame.dispose();
				gFrame = new GameFrame();
				gFrame.setVisible(true);
				break;
			case 1:
				break;
			case 2:
				frame.dispose();
				oFrame = new OptionsFrame();
				oFrame.setVisible(true);
				break;
			case 3:
				frame.dispose();
				eFrame = new EncyclopediaFrame();
				eFrame.setVisible(true);
				break;
		}
	}
	
	public static void startWaves() {
		startWave();
	}
	
	public static void locationSelected(int location) {
		gFrame.setPanelVisible(true);
		activeLocation = location;
	}
	
	public static void towerSelected(int tower) {
		Units.Towers.BasicTower b = new Units.Towers.BasicTower();
		gFrame.setTowerForLocation(b, activeLocation);
		gFrame.setPanelVisible(false);
	}
	
	public static void cancelSelected() {
		gFrame.setPanelVisible(false);
	}
	
	public static void startWave() {
		heartHealth = 1;
		eSpawner = new EnemySpawner();
		eSpawner.waveCreation();
		long turnStart = System.nanoTime();
		long turnEnd;
		long turnDelta;
		int counter = 0;
		CytotoxicTCell[] defense = new CytotoxicTCell[3];
		CytotoxicTCell i = new CytotoxicTCell(counter);
		i.setLocation(20 , 30);
		defense[0] = i;

		CytotoxicTCell i1 = new CytotoxicTCell(counter);
		i1.setLocation(20 + 5, 30);
		defense[1] = i1;

		CytotoxicTCell i2 = new CytotoxicTCell(counter);
		i2.setLocation(20 + 10, 30);
		defense[2] = i2;
		gFrame.addCytotoxicTCell();
		
		while (eSpawner.enemiesLeft() > 0 || heartHealth == 0) {
			turnStart = System.nanoTime();
			eSpawner.spawn();
			eSpawner.moveEnemies();
            eSpawner.checkCombat(defense);
			do{
				turnEnd = System.nanoTime();
				turnDelta = turnEnd - turnStart;
			} while (turnDelta < 100000000);
			turnEnd = 0;
			
		}
		if (heartHealth == 0) {
			System.out.println("game over");
		}
		eSpawner = null;
	}
	
	public static void drawEnemy(int x, int y){
		gFrame.drawEnemy(x, y);
	}
	
	public static void moveEnemy(int x, int y, IEnemy enemy){
		m.removeUnit(enemy.getLocationX(), enemy.getLocationY());
		m.placeUnit(x, y, enemy);
		gFrame.moveEnemy(x, y, enemy.ID());
	}
	
	public static void enemyDied(int id) {
		eSpawner.enemyDeath(eSpawner.getEnemy(id));
		gFrame.removeLabel(id);
	}
	
	public static void reachedHeart() {
		heartHealth--;
	}
	public static void startCombat(IEnemy enemy, CytotoxicTCell cell){
		long turnStart = System.nanoTime();
		long turnEnd;
		long turnDelta;
		  while (enemy.isAlive() && cell.isAlive()){
			  enemy.takeDamage(cell.dealDamage());
			  cell.takeDamage(enemy.dealDamage());
			  turnStart = System.nanoTime();
			  do{
					turnEnd = System.nanoTime();
					turnDelta = turnEnd - turnStart;
				} while (turnDelta < 100000000);
			  turnEnd = 0;
		  }
	  }
}
