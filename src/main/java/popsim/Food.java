package popsim;

class Food extends Entity implements Edible {
  int energy;

  public Food  () {
    super("+");
    this.energy = 4;
  }

  public boolean isOccupied() {
    return false;
  }


  public int eat() {
    return energy;
  }
}
