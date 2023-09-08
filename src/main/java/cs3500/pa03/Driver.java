package cs3500.pa03;

import cs3500.pa03.controller.GameController;
import cs3500.pa03.model.AIPlayer;
import cs3500.pa03.model.ManualPlayer;
import cs3500.pa03.model.Player;
import cs3500.pa03.view.GameViewer;
import java.util.Scanner;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    System.out.println("Hello from Battle Salvo - PA03 Template Repo");

    Player player = new ManualPlayer();
    Player opponent = new AIPlayer();
    GameViewer view = new GameViewer();

    GameController controller = new GameController(player, opponent, view);

    Scanner in = new Scanner(System.in);
    controller.run(in);
  }
}