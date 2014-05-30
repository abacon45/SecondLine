package GameEngine;
import java.awt.EventQueue;

import Units.Towers.*;
import Units.Enemy.*;


public class GameEngine {
	
	static StartMenu frame;
	static GameFrame gFrame;
	static OptionsFrame oFrame;
	static EncyclopediaFrame eFrame;
	static EnemySpawner eSpawner;
	static int activeLocation;
	
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
		BasicTower b = new BasicTower();
		gFrame.setTowerForLocation(b, activeLocation);
		gFrame.setPanelVisible(false);
	}
	
	public static void cancelSelected() {
		gFrame.setPanelVisible(false);
	}
	
	public static void startWave() {
		eSpawner = new EnemySpawner();
		eSpawner.waveCreation();
		while (eSpawner.enemiesLeft() > 0) {
			eSpawner.spawn();
			eSpawner.moveEnemies();
		}
		System.out.println("game over");
	}
	
	public static void drawEnemy(int x, int y){
		gFrame.drawEnemy(x, y);
	}
	public static void moveEnemy(int x, int y, int enemy){
		gFrame.moveEnemy(x, y, enemy);
	}
	
	public static void enemyDied(int id) {
		eSpawner.enemyDeath(eSpawner.getEnemy(id));
	}
	
}
