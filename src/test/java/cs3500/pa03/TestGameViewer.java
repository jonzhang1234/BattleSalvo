package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.SalvoInfo;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.view.GameViewer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameViewer {
  GameViewer view;

  @BeforeEach
  public void setup() {
    view = new GameViewer();
  }

  @Test
  public void testPromptDimensions() throws IOException {
    Path sampleFile = Path.of("src/test/resources/dimensions.txt");
    InputStream sampleInput = Files.newInputStream(sampleFile);
    Scanner in = new Scanner(sampleInput);
    int[] dim = view.promptDimensions(in);

    assertEquals(7, dim[0]);
    assertEquals(6, dim[1]);
  }

  @Test
  public void testPromptShips() throws IOException {
    Path sampleFile = Path.of("src/test/resources/ships.txt");
    InputStream sampleInput = Files.newInputStream(sampleFile);
    Scanner in = new Scanner(sampleInput);
    Map<ShipType, Integer> ships = view.promptShips(in, 6);

    assertEquals(1, ships.get(ShipType.CARRIER));
    assertEquals(2, ships.get(ShipType.BATTLESHIP));
    assertEquals(2, ships.get(ShipType.DESTROYER));
    assertEquals(1, ships.get(ShipType.SUBMARINE));
  }

  @Test
  public void testPromptShots() throws IOException {
    Path sampleFile = Path.of("src/test/resources/shots.txt");
    InputStream sampleInput = Files.newInputStream(sampleFile);

    List<Coord> shots = view.promptShots(sampleInput, 6, 10, 10);
    int i = 0;
    for (Coord c : shots) {
      assertEquals(0, c.getX());
      assertEquals(i, c.getY());
      i += 1;
    }
  }

  @Test
  public void testPrintShots() {
    List<Coord> userHits = new ArrayList<>();
    List<Coord> userMisses = new ArrayList<>();
    List<Coord> opponentHits = new ArrayList<>();
    List<Coord> opponenetMisses = new ArrayList<>();
    userHits.add(new Coord(0, 0));
    userMisses.add(new Coord(0, 1));
    opponentHits.add(new Coord(1, 0));
    opponenetMisses.add(new Coord(1, 1));
    SalvoInfo info = new SalvoInfo(userHits, userMisses, opponentHits, opponenetMisses);

    view.printShots(info);
  }

  @Test
  public void testPrintBoard() {
    char[][] sampleLetters = {{'S', 'H'}, {'M', '0'}};
    view.printBoard(sampleLetters, false);
    view.printBoard(sampleLetters, true);
  }
}
