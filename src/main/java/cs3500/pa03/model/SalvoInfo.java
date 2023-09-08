package cs3500.pa03.model;

import java.util.List;

/**
 * Responsible for containing info from each salvo
 */
public class SalvoInfo {
  private final List<Coord> userHits;
  private final List<Coord> userMissed;
  private final List<Coord> opponentHits;
  private final List<Coord> opponentMissed;

  /**
   * Constructor for SalvoInfo class

   * @param userHits list of coordinates that hit the opponent
   * @param userMissed list of coordinates that missed the opponent
   * @param opponentHits list of coordinates that hit the user
   * @param opponentMissed list of coordinates that missed the user
   */
  public SalvoInfo(List<Coord> userHits, List<Coord> userMissed, List<Coord> opponentHits,
                   List<Coord> opponentMissed) {
    this.userHits = userHits;
    this.userMissed = userMissed;
    this.opponentHits = opponentHits;
    this.opponentMissed = opponentMissed;
  }

  public String getUserHits() {
    return condenseCoords(userHits);
  }

  public String getUserMissed() {
    return condenseCoords(userMissed);
  }

  public String getOpponentHits() {
    return condenseCoords(opponentHits);
  }

  public String getOpponentMissed() {
    return condenseCoords(opponentMissed);
  }

  /**
   * Helper method for condensing a list of Coord to a string

   * @param coordList the list of Coord
   * @return the String representation
   */
  private String condenseCoords(List<Coord> coordList) {
    StringBuilder coordsString = new StringBuilder();
    for (Coord c : coordList) {
      coordsString.append(c.toString()).append(", ");
    }
    return coordsString.toString();
  }
}
