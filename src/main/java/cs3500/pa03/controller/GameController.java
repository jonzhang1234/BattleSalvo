package cs3500.pa03.controller;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Player;
import cs3500.pa03.model.SalvoInfo;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.view.GameViewer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsible for controlling the game
 */
public class GameController {
  private final Player player;
  private final Player opponent;
  private final GameViewer view;

  /**
   * Constructor for GameController

   * @param player the player
   * @param opponent the opponent
   * @param view the viewer
   */
  public GameController(Player player, Player opponent, GameViewer view) {
    this.player = player;
    this.opponent = opponent;
    this.view = view;
  }

  /**
   * Runs the game

   * @param in the Scanner to read the input
   */
  public void run(Scanner in) {
    int[] dim = view.promptDimensions(in);
    Map<ShipType, Integer> specs = view.promptShips(in, Math.min(dim[0], dim[1]));
    player.setup(dim[0], dim[1], specs);
    opponent.setup(dim[0], dim[1], specs);

    List<Coord> opponentShots = opponent.takeShots();
    List<Coord> playerShots = player.takeShots();

    while (playerShots.size() > 0 && opponentShots.size() > 0) {
      List<Coord> opponentHits = player.reportDamage(opponentShots);
      List<Coord> playerHits = opponent.reportDamage(playerShots);
      player.successfulHits(playerHits);
      opponent.successfulHits(opponentHits);
      List<Coord> playerMissed =
          playerShots.stream().filter((c) -> !playerHits.contains(c)).toList();
      List<Coord> opponentMissed =
          opponentShots.stream().filter((c) -> !opponentHits.contains(c)).toList();

      SalvoInfo info = new SalvoInfo(playerHits, playerMissed, opponentHits, opponentMissed);
      view.printShots(info);
      opponentShots = opponent.takeShots();
      playerShots = player.takeShots();
    }

    if (playerShots.size() == 0) {
      player.endGame(GameResult.LOSE, "All your ships sank");
      opponent.endGame(GameResult.WIN, "All opponents ships sank");
    } else {
      opponent.endGame(GameResult.LOSE, "All your ships sank");
      player.endGame(GameResult.WIN, "All opponents ships sank");
    }

  }

}
