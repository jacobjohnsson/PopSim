package popsim;

class RandomWalkerFactory implements PopFactory {
  public Pop create(Point pos) {
    return new RandomWalker(pos);
  }
}
