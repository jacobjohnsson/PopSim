package popsim;

public abstract class Entity {
  String symbol;

  public Entity  (String symbol) {
    this.symbol = symbol;
  }

  public void step(Entity[][] world) {}

  public abstract boolean isOccupied();

  @Override
  public String toString() {
    return symbol;
  }
}
