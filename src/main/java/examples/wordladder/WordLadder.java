package examples.wordladder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordLadder {
  public static void main(String[] args) throws IOException {
    // Words come from https://raw.githubusercontent.com/charlesreid1/five-letter-words/master/sgb-words.txt
    String filename = "src/main/resources/examples/5-letter-words.txt";
    Map<String, WordNode> dictionary = Files.lines(Paths.get(filename))
        .limit(10_000)
        .map(WordNode::new)
        .collect(Collectors.toMap(n -> n.word, n -> n));
    new WordLadder().findLadder(dictionary.get("table"), dictionary.get("crown"), dictionary);
  }

  void findLadder(WordNode startWord, WordNode endWord, Map<String, WordNode> dictionary) {
    boolean found = false;
    var frontier = new ArrayDeque<WordNode>();
    frontier.add(startWord); // The frontier starts with just the starting word
    var explored = new HashSet<WordNode>();

    while (!found && !frontier.isEmpty()) {
      WordNode exploring = frontier.pop();
      boolean alreadySeen = explored.contains(exploring);
      if (!alreadySeen) {
        explored.add(exploring);
        List<WordNode> newWordNodes = wordsOneDifferentFrom(exploring, dictionary);
        System.out.printf("%s -> %s, ex: %d, fr: %d\n", exploring, newWordNodes, explored.size(), frontier.size());

        for (WordNode newWordNode : newWordNodes) {
          if (newWordNode.equals(endWord)) {
            found = true;
            System.out.println("Word found!");
          } else
            frontier.add(newWordNode);
        }
      }
    }
  }


  /**
   * Returns a list of the words in the dictionary that are one letter
   * different from the given word.
   */
  static List<WordNode> wordsOneDifferentFrom(WordNode startingWord, Map<String, WordNode> dictionary) {
    return dictionary.values()
        .stream()
        .filter(wordNode -> numDifferentLetters(startingWord.word, wordNode.word) == 1)
        .collect(Collectors.toList());
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
