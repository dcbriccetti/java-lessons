package examples.simple;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
  public static void main(String[] args) {
    var app = new ListPractice();
    app.practice();
  }

  private void practice() {
    // Create an empty list
    // Learn about List and ArrayList
    List<Integer> numbers = new ArrayList<>();

    // Add to a list
    numbers.add(5);
    numbers.add(6);
    numbers.add(7);
    numbers.addAll(List.of(4, 8, 9, 11));

    // Loop over a list’s items
    for (int number : numbers) {
      System.out.println(number);
    }
    // Integer vs. int: two ways to hold integers, with the first used for Lists

    // Access a specific element of the list
    System.out.println(numbers.get(1));

  }
}
