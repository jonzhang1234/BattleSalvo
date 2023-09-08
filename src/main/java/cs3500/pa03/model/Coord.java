package cs3500.pa03.model;

/**
 * Represents a coordinate for the game
 */
public class Coord {
  private final int xcoord;
  private final int ycoord;

  /**
   * Constructor for Coord class

   * @param x the x coordinate
   * @param y the y coordinate
   */
  public Coord(int x, int y) {
    if (x >= 15 || y >= 15) {
      throw new IllegalArgumentException("Given values are out of range");
    }

    this.xcoord = x;
    this.ycoord = y;
  }

  public int getX() {
    return xcoord;
  }

  public int getY() {
    return ycoord;
  }

  public String toString() {
    return "[" + xcoord + ", " + ycoord + "]";
  }
}
