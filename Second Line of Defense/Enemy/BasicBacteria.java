public class BasicBacteria implements IEnemy {
  private boolean alive;
  private int id;
  public BasicBacteria(int newID) {
    alive = true;
    id = newID;
  }
  public boolean isAlive(){
    return alive;
  }
  public int ID(){
    return id;
  }
}