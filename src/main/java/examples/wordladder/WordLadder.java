package examples.wordladder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordLadder {
  public static void main(String[] args) throws IOException {
    // Words come from https://raw.githubusercontent.com/charlesreid1/five-letter-words/master/sgb-words.txt
    String filename = "src/main/resources/examples/5-letter-words.txt";
    List<String> words = Files.lines(Paths.get(filename)).limit(10_000).sorted().collect(Collectors.toList());
    for (String startingWord : words) {
      List<String> oneDifferentWords = wordsOneDifferentFrom(startingWord, words);
      if (! oneDifferentWords.isEmpty())
        System.out.printf("%s: %s\n", startingWord, oneDifferentWords);
    }
  }

  /**
   * Returns a list of the words in the dictionary that are one letter
   * different from the given word.
   */
  static List<String> wordsOneDifferentFrom(String startingWord, List<String> words) {
    List<String> wordsOneDifferentFrom = new ArrayList<>();
    for (String word : words) {
      int diffs = numDifferentLetters(startingWord, word);
      if (diffs == 1)
        wordsOneDifferentFrom.add(word);
    }

    return wordsOneDifferentFrom;
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
