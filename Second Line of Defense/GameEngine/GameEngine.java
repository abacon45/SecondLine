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
		long turnStart = System.nanoTime();
		long turnEnd;
		long turnDelta;
		
		while (eSpawner.enemiesLeft() > 0) {
			turnStart = System.nanoTime();
			eSpawner.spawn();
			eSpawner.moveEnemies();
			do{
				turnEnd = System.nanoTime();
				turnDelta = turnEnd - turnStart;
			} while (turnDelta < 50000000);
			turnEnd = 0;
			
		}
		
		System.out.println("game over");
	}
	
	public static void drawEnemy(int x, int y){
		gFrame.drawEnemy(x, y);
	}
	public static void moveEnemy(int x, int y, IEnemy enemy){
		m.placeUnit(x, y, enemy);
		gFrame.moveEnemy(x, y, enemy.ID());
	}
	
	public static void enemyDied(int id) {
		eSpawner.enemyDeath(eSpawner.getEnemy(id));
	}
	
	
}
