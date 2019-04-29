package popsim;

class NoEntity extends Entity {

  public NoEntity  () {
    super(".");
  }

  public boolean isOccupied() {
    return false;
  }

}
