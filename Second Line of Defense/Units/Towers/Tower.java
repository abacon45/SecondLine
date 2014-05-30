package Units.Towers;
import Units.*;
import Units.Enemy.*;
import java.awt.Image;

public class Tower implements IUnit {
 
 //Instance Variables
 private int xCoordinate;
 private int yCoordinate;
 private int id;
 private Image towerImage; //For changing tower image on button for different towers; to do
 private int range;
 
 //Constructors
 public Tower(int id){
   this.id = id;
   range = 20;
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
       isInRange = true;
     }     
   }
   return isInRange;
 }
}
