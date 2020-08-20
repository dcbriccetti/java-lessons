package examples.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads words from a file and displays a randomly-chosen one
 */
public class WordReader {
  public static void main(String[] args) {
    List<String> allWords = commonWords();
    var rand = new Random();
    int wordIndex = rand.nextInt(allWords.size());
    String word = allWords.get(wordIndex);
    System.out.println("Your word of the moment is " + word);
  }

  public static List<String> commonWords() {
    try {
      return wordsFromFile("src/main/resources/common-words.txt");
    } catch (IOException e) {
      return new ArrayList<>();
    }
  }

  public static List<String> wordsFromFile(String filename) throws IOException {
    Path wordsPath = Paths.get(filename);
    Stream<String> lines = Files.lines(wordsPath);
    return lines.collect(Collectors.toList());
  }
}


