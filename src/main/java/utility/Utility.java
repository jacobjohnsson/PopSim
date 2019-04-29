package utility;

import popsim.Entity;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Utility {
  public static Entity[][] shuffle(Entity[][] array) {
    int originalSize = array.length;
    List<Entity> flattened = flatten(array);
    Collections.shuffle(flattened);
    return unflatten(flattened, originalSize);
  }

  private static Entity[][] unflatten (List<Entity> flattened, int size) {
    Entity[][] result = new Entity[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = flattened.get(i*size + j);
      }
    }
    return result;
  }

  private static List<Entity> flatten (Entity[][] array) {
    List<Entity> result = new ArrayList<Entity>();
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        result.add(array[i][j]);
      }
    }
    return result;
  }
}
