package examples.simple;

import static java.lang.System.out;

public class Looping {
  public static void main(String[] args) {
    var words = new String[] {"cat", "monkey", "elevator"};
    for (String word : words) {
      out.println(word + " has " + word.length() + " letters.");
    }
    out.println("Here are the squares of the numbers from -5 to 5:");
    for (int num = -5; num <= 5; num++) {
      out.println(num * num);
    }
  }
}
