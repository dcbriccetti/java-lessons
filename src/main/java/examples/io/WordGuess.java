package examples.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static examples.io.WordReader.commonWords;

/**
 * Guess words by guessing letters
 */
public class WordGuess {
  public static void main(String[] args) {
    var words = getWords();
    System.out.println("(Shhhh...)  " + words);
    var s = new Scanner(System.in);
    while (true) {
      System.out.print("\nLetters? ");
      var letters = s.nextLine();
      if (letters.length() == 0)
        break;
      displayMatches(words, letters);
    }
    s.close();
  }

  private static void displayMatches(ArrayList<String> words, String letters) {
    for (String word : words) {
      if (word.equals(letters))
        System.out.println("You got " + word);
      for (char letter : word.toCharArray()) {
        char ch = letterIn(letter, letters) ? letter : '*';
        System.out.print(ch);
      }
      System.out.println();
    }
  }

  private static ArrayList<String> getWords() {
    List<String> allWords = commonWords();
    var rand = new Random();
    var words = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
      words.add(allWords.get(rand.nextInt(allWords.size())));
    }
    return words;
  }

  private static boolean letterIn(char letter, String letters) {
    for (int i = 0; i < letters.length(); i++)
      if (letters.charAt(i) == letter) return true;
    return false;
  }
}
