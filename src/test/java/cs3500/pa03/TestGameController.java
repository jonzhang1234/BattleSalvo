package cs3500.pa03;


import cs3500.pa03.controller.GameController;
import cs3500.pa03.model.AIPlayer;
import cs3500.pa03.model.Player;
import cs3500.pa03.view.GameViewer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameController {
  Player player;
  Player opponent;
  GameViewer view;
  GameController controller;

  @BeforeEach
  public void setup() {
    player = new MockPlayer();
    opponent = new AIPlayer();
    view = new GameViewer();

    controller = new GameController(player, opponent, view);
  }

  @Test
  public void testRun() throws IOException {
    Path sampleFile = Path.of("src/test/resources/controllerInput.txt");
    InputStream sampleInput = Files.newInputStream(sampleFile);
    Scanner in = new Scanner(sampleInput);
    controller.run(in);
  }

}
