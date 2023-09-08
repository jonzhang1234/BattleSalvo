package cs3500.pa03.model;

import cs3500.pa03.view.GameViewer;
import java.util.List;

/**
 * Responsible for implementing Player for a manual player
 */
public class ManualPlayer extends AbstractPlayer {
  /**
   * @return Manual for Manual player
   */
  public String name() {
    return "Manual";
  }

  /**
   * shows board and prompts player for input
   *
   * @return the list of shots took by this player
   */
  public List<Coord> takeShots() {
    GameViewer view = new GameViewer();
    System.out.println("Your Board:");
    view.printBoard(super.board.getLetters(), false);
    int width = super.board.getLetters().length;
    int height = super.board.getLetters()[0].length;
    return view.promptShots(System.in, super.board.getAliveShips(),
        width, height);
  }


}
