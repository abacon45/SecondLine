import java.awt.EventQueue;

import GameEngine.GameEngine;
import GameEngine.StartMenu;


public class Driver {
	
	
	
	public static void main(String[] args) {
		GameEngine g = GameEngine.getInstance();
		g.startMenu();
	}
}
