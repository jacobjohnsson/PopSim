package popsim;

class RandomWalker extends Pop {

  public RandomWalker  (Point pos) {
    super("M", pos, new RandomMover());
  }
}
