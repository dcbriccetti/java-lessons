package examples.simple;

import java.util.Scanner;

public class Interaction {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    System.out.println("What is your name?");
    var name = scanner.nextLine();
    System.out.println("Hello, " + name);
    scanner.close();
  }
}
