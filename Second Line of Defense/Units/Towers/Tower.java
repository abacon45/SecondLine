package Units.Towers;
import Units.*;
import Units.Enemy.*;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tower implements IUnit {
 
 //Instance Variables
 private int xCoordinate;
 private int yCoordinate;
 private int id;
 private ImageIcon towerImage; //For changing tower image on button for different towers; to do
 private int range;
 protected int baseDamage = 5;
 
 //Constructors
 public Tower(int id){
   this.id = id;
   range = 400;

   towerImage = new ImageIcon("Images/imgres-1.jpg");
	Image image = towerImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	towerImage.setImage(image);
 }
 
 public void setLocation(int w, int h) {
   xCoordinate = w;
   yCoordinate = h;
 }
 
 public int ID() {
   return id;
 }
 
 public boolean inRange(IEnemy enemy){
   double x, y;
   boolean isInRange = false;
   x = (double) enemy.getLocationX();
   y = (double) enemy.getLocationY();
   if (this.range >= (Math.abs((double) this.xCoordinate - x))){
     if (this.range >= (Math.abs((double) this.yCoordinate - y))){
    	 System.out.println("Hello");
       isInRange = true;
     }     
   }
   return isInRange;
 }
 
 public int dealDamage() {
   return baseDamage;
 }
 
 public int getLocationX() {
   return xCoordinate;
 }
 
 public int getLocationY() {
   return yCoordinate;
 }
 public ImageIcon getIcon() {
  return towerImage;
 }
}
