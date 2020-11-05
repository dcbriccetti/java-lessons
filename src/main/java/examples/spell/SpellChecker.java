package examples.spell;

import java.util.Scanner;

/**
 * Allows the user to type sentences. Highlights
 * misspelled words, using a set of words.
 */
public class SpellChecker {
  public static void main(String[] args) {
    var dictionary = new Dictionary();
    var scanner = new Scanner(System.in);
    System.out.println("Enter a sentence.");
    var sentence = scanner.nextLine();
    var words = sentence.split(" ");
    for (String word : words) {
      if (!dictionary.contains(word)) {
        System.out.println("No such word");
      }
    }
    scanner.close();
  }
}
