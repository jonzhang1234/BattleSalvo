package cs3500.pa03;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Player;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Mock class to test controller and driver
 */
public class MockPlayer implements Player {
  private final List<Coord> dummyCoords = new ArrayList<>();

  /**
   * @return null
   */
  public String name() {
    return null;
  }

  /**
   * Sets dummyCoords

   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return null
   */
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    dummyCoords.add(new Coord(0, 0));
    dummyCoords.add(new Coord(0, 0));
    return null;
  }

  /**
   * Removes one element from dummyList

   * @return dummyList
   */
  public List<Coord> takeShots() {
    dummyCoords.remove(0);
    return dummyCoords;
  }

  /**
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return empty list
   */
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return new ArrayList<>();
  }

  /**
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {

  }

  /**
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  public void endGame(GameResult result, String reason) {

  }
}
