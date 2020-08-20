package examples.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads words from a file
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
    return wordsFromFile("src/main/resources/common-words.txt");
  }

  public static List<String> manyWords() {
    return wordsFromFile("/usr/share/dict/words");
  }

  public static List<String> wordsFromFile(String filename) {
    Path wordsPath = Paths.get(filename);
    Stream<String> lines;
    try {
      lines = Files.lines(wordsPath);
    } catch (IOException e) {
      System.err.println(e.toString());
      return Collections.emptyList();
    }
    return lines.filter(line -> ! line.startsWith("#")).collect(Collectors.toList());
  }
}


