package examples.adventcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
  public static void main(String[] args) {
    var nums = readNumbers();

    for (int i = 0; i < nums.size() - 1; i++) {
      for (int j = i + 1; j < nums.size(); j++) {
        int num1 = nums.get(i);
        int num2 = nums.get(j);
        System.out.printf("i: %d, j: %d, nums.get(i): %d, nums.get(j): %d\n", i, j, num1, num2);
        if (num1 + num2 == 2020) {
          System.out.println(num1 * num2);
        }
      }
    }
  }

  /**
   * Load the lines of text from a file into memory
   * @return a list of the integers in the file
   */
  private static List<Integer> readNumbers() {
    try {
      String filename = "/Users/daveb/devel/java-lessons/src/main/resources/examples/adventcode/Day1Test.txt";
      Stream<String> linesStream = Files.lines(Paths.get(filename));
      return linesStream.map(Integer::parseInt).collect(Collectors.toList());
    } catch (IOException e) {
      System.err.println(e.toString());
      return Collections.emptyList();
    }
  }
}
