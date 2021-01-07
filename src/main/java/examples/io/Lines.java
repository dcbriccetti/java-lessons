package examples.io;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static examples.io.WordReader.wordsFromFile;

public class Lines {
  public static void main(String[] args) {
    Set<String> words = new HashSet<>(commonWords());
    System.out.println(words);
  }
  public static List<String> commonWords() {
    return wordsFromFile("src/main/resources/common-words.txt");
  }

}
