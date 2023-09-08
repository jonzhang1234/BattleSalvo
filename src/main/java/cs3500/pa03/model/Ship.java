package cs3500.pa03.model;

/**
 * Responsible for representing a BattleSalvo ship
 */
public class Ship {
  private final ShipType type;
  private final Coord[] coords;

  public Ship(ShipType t, Coord[] c) {
    type = t;
    coords = c;
  }

  public ShipType getType() {
    return type;
  }

  public Coord[] getCoords() {
    return coords;
  }
}
