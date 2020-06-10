package examples.simple;

import java.util.Scanner;

public class Conditions {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    System.out.println("Please guess my integer from 1 to 3");
    var number = scanner.nextInt();
    System.out.println(number == 3 ? "Right!" : "Sorry.");
    scanner.close();
  }
}
