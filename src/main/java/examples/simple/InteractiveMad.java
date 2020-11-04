package examples.simple;
import java.util.ArrayList; // LIST
import java.util.Scanner;

public class InteractiveMad {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var numbers = new ArrayList<Integer>();  // LIST
    System.out.print("How many numbers? ");
    int numNums = scanner.nextInt();
    for (int n = 1; n <= numNums; ++n) {
      System.out.print("==> ");
      int num = scanner.nextInt();
      numbers.add(num); // LIST
    }
    System.out.println(numbers); // LIST  (prints whole list)
    System.out.println(numbers.get(0)); // LIST  (prints element 0)
    for (int number : numbers) { // LIST  (prints all elements separately
      System.out.println(number);
    }
    // Find and print the highest number in the list
    // You may want a `for` loop like the one just above,
    // and a variable to hold the highest number found so far.
  }
}
