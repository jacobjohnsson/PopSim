package popsim;

abstract class Pop extends Entity {
  int energy;
  Point pos;
  MoveBehavior behavior;

  public Pop  (String symbol, Point pos, MoveBehavior behavior) {
    super(symbol);
    this.pos = pos;
    this.behavior = behavior;
    energy = 12;
  }

  public boolean isOccupied() {
    return true;
  }

  public void move(Entity[][] world) {
    energy--;
    pos = behavior.move(pos, world);
  }
}
