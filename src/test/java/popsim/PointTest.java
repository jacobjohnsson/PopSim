package popsim;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PointTest {

  Point p1;
  Point p2;

  @Before
  public void setup() {
    p1 = new Point(0, 0);
    p2 = new Point(2, 4);
  }

  @Test
  public void testIsWithin() {
    assertTrue(p2.isWithin(0, 10, 0, 10));
  }
  @Test
  public void testIsNotWithin() {
    assertFalse(p1.isWithin(1, 10, 1, 10));
  }

  @Test
  public void testEquals() {
    Point p3 = new Point(2, 4);
    assertEquals(p2, p3);
  }

  @Test
  public void testNotEquals() {
    assertFalse(p1.equals(p2));
  }

  @Test
  public void testMove() {
    assertEquals(p1.move(2, 4), p2);
  }
}
