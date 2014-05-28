package Towers;


import java.awt.Image;

import Enemy.IEnemy;
import java.lang.Math;

public class Tower{
	
	//Instance Variables
	private boolean empty = true;
	private int xCoordinate;
	private int yCoordinate;
	private String type;
	private Image towerImage; //For changing tower image on button for different towers; to do
	private int range;
	
	//Constructors
	public Tower(int xLoc, int yLoc){
		xCoordinate = xLoc;
		yCoordinate = yLoc;
		range = 20;
	}
	
	//Methods
	public boolean isEmpty(){
		return empty;
	}
	public void build(){
		empty = false;
	}
	public void setType(String aType)
	{
		type = aType;
	}
	
	public String getType()
	{
		return type; 
	}
	public boolean inRange(IEnemy enemy){
		double x, y;
		boolean isInRange = false;
		x = (double) enemy.getLocationX();
		y = (double) enemy.getLocationY();
		if (this.range >= (Math.abs((double) this.xCoordinate - x))){
				if (this.range >= (Math.abs((double) this.yCoordinate - y))){
					isInRange = true;
				}					
		}
		return isInRange;
	}
}
