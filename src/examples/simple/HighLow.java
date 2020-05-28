package examples.simple;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
  public static void main(String[] args) {
    int randomInt = new Random().nextInt(100) + 1;
    var scanner = new Scanner(System.in);
    var guess = 0;
    var numGuesses = 0;

    while (guess != randomInt) {
      System.out.println("Please guess my integer from 1 to 100");
      guess = scanner.nextInt();
      ++numGuesses;
      String message;
      if (guess == randomInt) {
        message = "Right!";
      } else if (guess < randomInt) {
        message = "Too low";
      } else {
        message = "Too high";
      }
      System.out.println(message);
    }

    System.out.println("You took " + numGuesses + " guesses");
  }
}
