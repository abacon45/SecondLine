package GameEngine;
import java.awt.EventQueue;
import java.util.LinkedList;

import Map.Map;
import Player.Player;
import Units.IUnit;
import Units.Towers.*;
import Units.Enemy.*;


public class GameEngine {
	
	static StartMenu frame;
	static GameFrame gFrame;
	static GameOverFrame gOFRAME;
	static OptionsFrame oFrame;
	static EncyclopediaFrame eFrame;
	static EnemySpawner eSpawner;
	static int activeLocation;
	static Map m = new Map(40,60);
	static int heartHealth;
	private Player me;
	LinkedList<Tower> towers = new LinkedList<Tower>();
	
	public static GameEngine g;
	
	private int[] towerLocationsX = {254,225,90,306,0,90};
	private int[] towerLocationsY = {115,256,555,555,229,30};
	
	private GameEngine(){
		me = new Player();
	}
	
	public static GameEngine getInstance() {
		if (g == null) {
			g = new GameEngine();
		}
		return g;
	}
	
	public void startMenu() {
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
	
	public void startMenuButtonPressed(int button) {
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
	
	public void startWaves() {
		startWave();
	}
	
	public void locationSelected(int location) {
		if (gFrame != null) {
			gFrame.setPanelVisible(true);
			activeLocation = location;
		}
	}
	
	public void towerSelected(int tower) {
		Tower t = null;
		if (tower == 0) {
			t = new Tower(activeLocation);
			t.setLocation(towerLocationsX[activeLocation], towerLocationsY[activeLocation]);
		} else if (tower == 1) {
			t = new BCellTower(activeLocation);
			t.setLocation(towerLocationsX[activeLocation], towerLocationsY[activeLocation]);
		} else if (tower == 2) {
			
		}
		towers.add(t);
		if (me.spendDNA(50)) {
			gFrame.updateDNA(me.getDNA());
			if (gFrame != null) {
				gFrame.setTowerForLocation(t, activeLocation);
				gFrame.setPanelVisible(false);
			}
		} else {
			gFrame.setPanelVisible(false);
		}
		
	}
	
	public void cancelSelected() {
		if (gFrame != null)
			gFrame.setPanelVisible(false);
	}
	
	public void startWave() {
		eSpawner = new EnemySpawner();
		eSpawner.waveCreation();
		heartHealth = eSpawner.enemiesTotal() / 3;
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
            eSpawner.checkCombat(defense, towers);
			do{
				turnEnd = System.nanoTime();
				turnDelta = turnEnd - turnStart;
			} while (turnDelta < 100000000);
			turnEnd = 0;
			counter++;
			
		}
		if (heartHealth == 0) {
			gFrame.dispose();
			gOFRAME = new GameOverFrame();
			gOFRAME.setVisible(true);
			System.out.println("game over");
		}
		eSpawner = null;
		gFrame.clearDefense();
	}
	
	public void drawEnemy(int x, int y){
	    if (gFrame != null) 
	    	gFrame.drawEnemy(x, y);
	}
	
	public void moveEnemy(int x, int y, IEnemy enemy){
		m.removeUnit(enemy.getLocationX(), enemy.getLocationY());
		m.placeUnit(x, y, enemy);
		if (gFrame != null)
			gFrame.moveEnemy(x, y, enemy.ID());
	}
	
	public void enemyDied(int id) {
		me.addDNA(50);
		gFrame.updateDNA(me.getDNA());
		if (eSpawner != null)
			eSpawner.enemyDeath(eSpawner.getEnemy(id));
		if (gFrame != null)
			gFrame.removeEnemyLabel(id);
	}
	
	public void cellDied(int id) {
		if (gFrame != null)
			gFrame.removeCellLabel(id);
	}
	
	public void reachedHeart() {
		heartHealth--;
	}
	public void startCombat(IEnemy enemy, CytotoxicTCell cell){
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
	
	public void fire(IEnemy enemy, Tower t) {
		enemy.takeDamage(t.dealDamage());
	}
}
