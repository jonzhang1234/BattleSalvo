package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.AIPlayer;
import cs3500.pa03.model.AbstractPlayer;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBoard {
  AbstractPlayer player1;
  AbstractPlayer player2;
  Map<ShipType, Integer> specs;
  Board b;
  List<Ship> ships;

  @BeforeEach
  public void setup() {
    player1 = new ManualPlayer();
    player2 = new AIPlayer();
    specs = new HashMap<>();

    specs.put(ShipType.CARRIER, 1);
    specs.put(ShipType.BATTLESHIP, 2);
    specs.put(ShipType.DESTROYER, 2);
    specs.put(ShipType.SUBMARINE, 1);
    ships = player1.setup(10, 10, specs);
    b = new Board(ships, 10, 10);
  }

  @Test
  public void testSetHits() {
    List<Coord> hits = new ArrayList<>();
    Collections.addAll(hits, ships.get(0).getCoords());

    assertEquals(6, b.getAliveShips());
    b.setHits(hits);
    char[][] letters = b.getLetters();
    for (Coord c : hits) {
      assertEquals('H', letters[c.getX()][c.getY()]);
    }
    assertEquals(5, b.getAliveShips());
  }

  @Test
  public void testSetMiss() {
    List<Coord> misses = new ArrayList<>();
    misses.add(new Coord(0, 0));
    misses.add(new Coord(0, 1));
    misses.add(new Coord(1, 0));
    misses.add(new Coord(1, 1));

    b.setMisses(misses);
    char[][] letters = b.getLetters();
    for (Coord c : misses) {
      assertEquals('M', letters[c.getX()][c.getY()]);
    }
  }
}
