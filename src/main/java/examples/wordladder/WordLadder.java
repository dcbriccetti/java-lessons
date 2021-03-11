package examples.wordladder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordLadder {
  public static void main(String[] args) throws IOException {
    // Words come from https://raw.githubusercontent.com/charlesreid1/five-letter-words/master/sgb-words.txt
    String filename = "src/main/resources/examples/5-letter-words.txt";
    List<String> dictionary = Files.lines(Paths.get(filename)).limit(10_000).sorted().collect(Collectors.toList());
    new WordLadder().findLadder("table", "crown", dictionary);
  }

  void findLadder(String startWord, String endWord, List<String> dictionary) {
    boolean found = false;
    var frontier = new ArrayDeque<String>();
    frontier.add(startWord); // The frontier starts with just the starting word
    var explored = new HashSet<String>();

    while (!found && !frontier.isEmpty()) {
      String exploring = frontier.pop();
      boolean alreadySeen = explored.contains(exploring);
      if (!alreadySeen) {
        explored.add(exploring);
        List<String> newWords = wordsOneDifferentFrom(exploring, dictionary);
        System.out.printf("%s -> %s, ex: %d, fr: %d\n", exploring, newWords, explored.size(), frontier.size());

        for (String newWord : newWords) {
          if (newWord.equals(endWord)) {
            found = true;
            System.out.println("Word found!");
          } else
            frontier.add(newWord);
        }
      }
    }
  }


  /**
   * Returns a list of the words in the dictionary that are one letter
   * different from the given word.
   */
  static List<String> wordsOneDifferentFrom(String startingWord, List<String> dictionary) {
    return dictionary.stream().filter(word -> numDifferentLetters(startingWord, word) == 1).collect(Collectors.toList());
  }

  /**
   * Returns the number of letters that are different between the two words.
   * For example: crops, crows differ in the 4th letter, so the method would return 1
   **/
  static int numDifferentLetters(String word1, String word2) {
    int differences = 0;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        ++differences;
      }
    }
    return differences;
  }

}
