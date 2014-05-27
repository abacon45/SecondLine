package Towers;

import java.awt.Image;

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
}