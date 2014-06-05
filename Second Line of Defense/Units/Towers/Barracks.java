package Units.Towers;
import java.util.HashMap;
import java.util.Iterator;
import Units.IUnit;
public class Barracks {
  private static int startingCellCount = 3;
  private static int typeID = 100;
  private int currentCellCount = 0;
  HashMap<Integer, CytotoxicTCell> units = new HashMap<Integer, CytotoxicTCell>();
  
  public Barracks() {
    for (int i = 0; i < startingCellCount; i++) {
      CytotoxicTCell c = new CytotoxicTCell(typeID + i);
      addCell(c);
    }
  }
  
  public int cellsActive() {
    return currentCellCount;
  }
  
  public void addCell(CytotoxicTCell aUnit){
    units.put(aUnit.ID(), aUnit);
    currentCellCount ++;
  }
  
  public CytotoxicTCell getCell(int id){
    return units.get(id);
  }
  
  private void clearDeadCells() {
    Object[] iter = units.keySet().toArray();
    for (int i = typeID; i < iter.length + typeID; i++) {
      CytotoxicTCell val = (CytotoxicTCell)units.get(i);
      System.out.println((char)val.ID());
      if (! val.isAlive()) {
        units.remove(i);
        currentCellCount --;
      }
    }
  }
  
  public void repopulate() {
    clearDeadCells();
    for (int i = typeID; i < startingCellCount + typeID; i++){
      if (!units.containsKey(i)){
        CytotoxicTCell cell = new CytotoxicTCell(i);
        addCell(cell);
      } 
    }
  }
  public void upgrade(){
    for (int i = typeID; i < startingCellCount + typeID; i++){
      if (units.containsKey(i)){
        getCell(i).upgradeDamage();
      } 
    }
  }
  
}
