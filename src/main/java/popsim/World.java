package popsim;

import java.util.Collections;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

class World {
  Entity[][] world;
  int size;
  List<Pop> pops;

  public World  (int size, PopFactory pf) {
    this.size = size;
    this.world = new Entity[size][size];
    this.pops = new ArrayList<Pop>();
    emptyAll(world);
    fillMiddle();
    addPopAt(1, 1, pf);
    addPopAt(1, 3, pf);
    addPopAt(3, 3, pf);
  }

  public void step() {
    for (Pop pop : pops) {
      System.out.println("Pop is moving!");
      pop.move(world);
    }
  }

  private void addPopAt(int x, int y, PopFactory pf) {
    Point p = new Point(x, y);
    Pop pop = pf.create(p);
    world[x][y] = pop;
    pops.add(pop);
  }

  private void fillMiddle() {
    int midSize = size - 2;
    Entity[][] middle = new Entity[midSize][midSize];

    emptyAll(middle);
    addFood(middle);
  }

  private void addFood(Entity[][] middle) {
    for (int i = 0; i < size - 2; i++) {
      middle[0][i] = new Food();
    }
    Entity[][] newMiddle = utility.Utility.shuffle(middle);
    insertMiddle(newMiddle);
  }

  private void emptyAll(Entity[][] middle) {
    for (int i = 0; i < middle.length; i++) {
      for (int j = 0; j < middle.length; j++) {
        middle[i][j] = new NoEntity( );
      }
    }
  }

  private void insertMiddle(Entity[][] middle) {
    for (int i = 0; i < size - 2; i++) {
      for (int j = 0; j < size - 2; j++) {
        world[i + 1][j + 1] = middle[i][j];
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= size + 1; i++) {
      sb.append("- ");
    }
    sb.append("\n");

    for (int i = 0; i < size; i++) {
      sb.append("¦ ");
      for (int j = 0; j < size; j++) {
        sb.append(world[i][j] + " ");
      }
      sb.append("¦\n");
    }

    for (int i = 0; i <= size + 1; i++) {
      sb.append("- ");
    }
    return sb.toString();
  }
}
