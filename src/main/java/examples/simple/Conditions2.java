package examples.simple;

import java.util.Random;
import java.util.Scanner;

public class Conditions2 {
  public static void main(String[] args) {
    int randomInt = new Random().nextInt(5) + 1;
    var scanner = new Scanner(System.in);
    System.out.println("Please guess my integer from 1 to 5");
    var number = scanner.nextInt();
    String message;
    if (number == randomInt) {
      message = "Right!";
    } else if (number < randomInt) {
      message = "Too low";
    } else {
      message = "Too high";
    }
    scanner.close();
    System.out.println(message);
  }
}
