package examples.simple;

import java.util.Random;
import java.util.Scanner;

/**
 * High/Low Guessing Game
 */
public class HighLow {
  public static void main(String[] args) {
    final int UPPER_LIMIT = 100;
    int randomInt = new Random().nextInt(UPPER_LIMIT) + 1;
    var scanner = new Scanner(System.in);
    var guess = 0;
    var numGuesses = 0;

    while (guess != randomInt) {
      System.out.println("Please guess my integer from 1 to " + UPPER_LIMIT);
      guess = scanner.nextInt();
      ++numGuesses;
      if (guess < randomInt) {
        System.out.println("Too low");
      } else if (guess > randomInt) {
        System.out.println("Too high");
      }
    }

    scanner.close();
    System.out.println("You got it in " + numGuesses + " guesses");
  }
}
