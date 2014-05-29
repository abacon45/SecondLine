import java.util.ArrayList;
import Units.IUnit;

public class Map {
  int x, y;
  ArrayList<EntryPoint> entryPoints;
  IUnit[][] grid;
  
  public Map(int x, int y) {
    entryPoints = new ArrayList<EntryPoint>();
    this.x = x;
    this.y = y;
    grid = new IUnit[x][y];
  }
  
  public int[] heartLocation() {
    int[] heartLocation = new int[] {x / 2, y - 5};
    return heartLocation;
  }
  
  public void initEntryPoint(int x, int y) {
    EntryPoint e = new EntryPoint(x, y);
    entryPoints.add(e);
  }
  
  public ArrayList<EntryPoint> getEntryPoints() {
    return entryPoints;
  }
  
  public boolean isEmpty(int w, int h) {
      return grid[w][h] == null;
  }
  
  public void placeUnit(int w, int h, IUnit unit) {
    grid[w][h] = unit;
    unit.setLocation(w, h);
  }
}
