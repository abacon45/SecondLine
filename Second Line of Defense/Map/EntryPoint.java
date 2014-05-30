package Map;
public class EntryPoint {
  int x, y;
  public EntryPoint(int x, int y) {this.x = x; this.y = y;}
  public int getX() {return x;}
  public int getY() {return y;}
 
  public boolean equals(Object object) {
    if (object instanceof EntryPoint) {
      if (this.x == ((EntryPoint) object).getX() && this.y == ((EntryPoint) object).getY()) return true;
    }
    return false;
  }
}
