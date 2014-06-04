package GameEngine;
import java.awt.EventQueue;
import java.util.LinkedList;

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
		eSpawner = new EnemySpawner();
		eSpawner.waveCreation();
		heartHealth = eSpawner.enemiesTotal() / 3;
		System.out.println(heartHealth);
		long turnStart = System.nanoTime();
		long turnEnd;
		long turnDelta;
		int counter = 0;
		
		LinkedList<CytotoxicTCell> defense = new LinkedList<CytotoxicTCell>();
		CytotoxicTCell i = new CytotoxicTCell(0);
		i.setLocation(17 , 30);
		defense.add(i);

		CytotoxicTCell i1 = new CytotoxicTCell(1);
		i1.setLocation(17, 35);
		defense.add(i1);

		
		gFrame.CytotoxicTCellCell(defense);
		

		eSpawner.spawn();
		while (eSpawner.enemiesLeft() > 0 && heartHealth > 0) {
			turnStart = System.nanoTime();
			if (counter >= 10) {
				eSpawner.spawn();
				counter = 0;
			}
			eSpawner.moveEnemies();
            eSpawner.checkCombat(defense);
			do{
				turnEnd = System.nanoTime();
				turnDelta = turnEnd - turnStart;
			} while (turnDelta < 100000000);
			turnEnd = 0;
			counter++;
			
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
		gFrame.removeEnemyLabel(id);
	}
	
	public static void cellDied(int id) {
		gFrame.removeCellLabel(id);
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
