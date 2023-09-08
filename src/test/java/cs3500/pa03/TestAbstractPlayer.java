package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.AIPlayer;
import cs3500.pa03.model.AbstractPlayer;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAbstractPlayer {
  AbstractPlayer player1;
  AbstractPlayer player2;
  Map<ShipType, Integer> specs;

  @BeforeEach
  public void setup() {
    player1 = new ManualPlayer();
    player2 = new AIPlayer();
    specs = new HashMap<>();

    specs.put(ShipType.CARRIER, 1);
    specs.put(ShipType.BATTLESHIP, 2);
    specs.put(ShipType.DESTROYER, 2);
    specs.put(ShipType.SUBMARINE, 1);
  }

  @Test
  public void testSetup() {
    List<Ship> ships1 = player1.setup(10, 10, specs);
    List<Ship> ships2 = player2.setup(10, 10, specs);


    assertEquals(6, ships1.size());
    assertEquals(6, ships2.size());

    for (Ship s : ships1) {
      assertEquals(s.getType().size, s.getCoords().length);
    }

    for (Ship s : ships2) {
      assertEquals(s.getType().size, s.getCoords().length);
    }
  }

  @Test
  public void testReportDamage() {
    List<Ship> ships = player1.setup(10, 10, specs);
    List<Coord> shots = new ArrayList<>();

    shots.add(ships.get(0).getCoords()[0]);
    shots.add(ships.get(0).getCoords()[1]);
    shots.add(ships.get(1).getCoords()[0]);
    shots.add(ships.get(1).getCoords()[1]);
    shots.add(new Coord(0, 0));
    shots.add(new Coord(0, 1));
    List<Coord> hits = player1.reportDamage(shots);

    assertTrue(shots.containsAll(hits));
  }
}
