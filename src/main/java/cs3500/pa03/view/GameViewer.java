package cs3500.pa03.view;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.SalvoInfo;
import cs3500.pa03.model.ShipType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsible for viewing a battleship game
 */
public class GameViewer {
  /**
   * Prompts user for dimensions of the board to start the game

   * @param in the Scanner to read inputs
   * @return height as the first element and width as the second
   */
  public int[] promptDimensions(Scanner in) {
    System.out.println("Hello! Welcome to the OOD BattleSalvo Game!");
    System.out.println("Please enter a valid height and width below:");
    int height = in.nextInt();
    int width = in.nextInt();
    while (height < 6 || height > 15 || width < 6 || width > 15) {
      System.out.println("Uh Oh! You've entered invalid dimensions."
          + " Please remember that the height and width");
      System.out.println("of the game must be in the range (6, 10), inclusive. Try again!");
      height = in.nextInt();
      width = in.nextInt();
    }

    return new int[] {height, width};
  }

  /**
   * Prompts user for number of ships for each type

   * @param in the Scanner to read inputs
   * @param smallestDim size of the smallest dimension of the board
   * @return a map of shiptype to the inputted numbers for each type
   */
  public Map<ShipType, Integer> promptShips(Scanner in, int smallestDim) {

    System.out.println("Please enter your fleet in the order"
        + " [Carrier, Battleship, Destroyer, Submarine].");
    System.out.println("Remember, your fleet may not exceed size " + smallestDim + ".");

    int c = in.nextInt();
    int b = in.nextInt();
    int d = in.nextInt();
    int s = in.nextInt();

    while (c < 1 || b < 1 || d < 1 || s < 1 || c + b + d + s > smallestDim) {
      System.out.println("Uh Oh! You've entered invalid fleet sizes.");
      System.out.println("Please enter your fleet in the order"
          + " [Carrier, Battleship, Destroyer, Submarine].");
      System.out.println("Remember, your fleet may not exceed size " + smallestDim + ".");
      c = in.nextInt();
      b = in.nextInt();
      d = in.nextInt();
      s = in.nextInt();
    }
    Map<ShipType, Integer> specs = new HashMap<>();
    specs.put(ShipType.CARRIER, c);
    specs.put(ShipType.BATTLESHIP, b);
    specs.put(ShipType.DESTROYER, d);
    specs.put(ShipType.SUBMARINE, s);
    return specs;
  }

  /**
   * Prompts user for shots

   * @param stream the stream to take inputs
   * @param alive the number of alive ships the player has
   * @param width the width of the player's board
   * @param height the height of the player's board
   * @return the list of Coords to shot at
   */
  public List<Coord> promptShots(InputStream stream, int alive, int width, int height) {
    Scanner in = new Scanner(stream);
    List<Coord> coords = new ArrayList<>();

    System.out.println("Please Enter " + alive + " Shots (x, y):");

    int x;
    int y;
    for (int s = 0; s < alive; s += 1) {
      x = in.nextInt();
      y = in.nextInt();
      if (x >= 0 && x < width && y >= 0 && y < height) {
        coords.add(new Coord(x, y));
      } else {
        System.out.println("Invalid coordinates, x and y must be within (" + width
            + ", " + height + "), try again:");
        s -= 1;
      }
    }
    return coords;
  }

  /**
   * Prints the hits and misses of each player

   * @param info the info from the salvo
   */
  public void printShots(SalvoInfo info) {
    System.out.println("Shots fired by the user which hit AI ships: \n"
        + info.getUserHits());
    System.out.println("Shots fired by the user which did not hit ships: \n"
        + info.getUserMissed());
    System.out.println("Shots fired by the AI which hit user ships: \n"
        + info.getOpponentHits());
    System.out.println("Shots fired by the AI which did not hit user ships: \n"
        + info.getOpponentMissed());
  }

  /**
   * Prints the given board

   * @param letters the letters of the board to print
   * @param hidden whether the ships should be hidden
   */
  public void printBoard(char[][] letters, boolean hidden) {
    int cols = letters.length;
    int rows = letters[0].length;

    for (int r = 0; r < rows; r += 1) {
      for (int c = 0; c < cols; c += 1) {
        if (hidden) {
          if (letters[c][r] == 'H' || letters[c][r] == 'M') {
            System.out.print(letters[c][r] + "  ");
          } else {
            System.out.print("0  ");
          }
        } else {
          System.out.print(letters[c][r] + "  ");
        }
      }
      System.out.println();
    }
  }
}
