package popsim;

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class RandomMover implements MoveBehavior {

  public Point move(Point currentPos, Entity[][] world) {

    List<Point> moves = createPossibleMoves(currentPos, world);

    Point move = chooseMove(currentPos, moves, world);

    return move;
  }

  private Point chooseMove(Point oldPos, List<Point> moves, Entity[][] world) {
    Collections.shuffle(moves);
    Point newPos = moves.get(0);
    int newX = newPos.getX();
    int newY = newPos.getY();
    int oldX = oldPos.getX();
    int oldY = oldPos.getY();

    int index = 1;
    while (world[newX][newY].isOccupied()) {
      newPos = moves.get(index);
      newX = newPos.getX();
      newY = newPos.getY();

      index++;
      if (index == 8) {
        newPos = oldPos;
        break;
      }
    }

    world[newX][newY] = world[oldX][oldY];
    world[oldX][oldY] = new NoEntity();

    return newPos;
  }

  private List<Point> createPossibleMoves(Point pos, Entity[][] world) {
    List<Point> moves = new ArrayList<>();
    for (int dx = -1; dx < 2; dx++) {
      for (int dy = -1; dy < 2; dy++) {
        if (dx != 0 && dy != 0) {
          Point possibleMove = pos.move(dx, dy);

          // only add moves that are withing the bounds.
          if (possibleMove.isWithin(0, world.length, 0, world.length)) {
            moves.add(pos.move(dx, dy));
          }
        }
      }
    }
    return moves;
  }
}
