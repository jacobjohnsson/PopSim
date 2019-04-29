package popsim;

class Point {
  int x;
  int y;

  public Point  (int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point move(int dx, int dy) {
    return new Point(x + dx, y + dy);
  }

  public boolean isWithin(int x1, int x2, int y1, int y2) {
    return x1 <= x && x <= x2 && y1 <= y && y <= y2;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Point)) {
      return false;
    }

    Point that = (Point) o;

    return this.x == that.x && this.y == that.y;
  }
}
