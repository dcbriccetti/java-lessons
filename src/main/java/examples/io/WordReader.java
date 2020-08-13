package examples.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads words from a file and displays a randomly-chosen one
 */
public class WordReader {
  public static void main(String[] args) throws IOException {
    Path wordsPath = Paths.get("src/main/resources/common-words.txt");
    Stream<String> lines = Files.lines(wordsPath);
    List<String> allWords = lines.collect(Collectors.toList());
    var rand = new Random();
    int wordIndex = rand.nextInt(allWords.size());
    String word = allWords.get(wordIndex);
    System.out.println("Your word of the moment is " + word);
  }
}

