package popsim;

abstract interface MoveBehavior {
  public Point move(Point pos, Entity[][] world);
}
