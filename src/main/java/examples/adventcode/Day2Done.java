package examples.adventcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class Day2Done {
  static class PasswordCheck {
    int num1;
    int num2;
    char letter;
    String password;
    static Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (.): (\\w+)");

    public PasswordCheck(String line) {
      System.out.println(line);
      var m = pattern.matcher(line);
      m.matches();
      num1 = Integer.parseInt(m.group(1));
      num2 = Integer.parseInt(m.group(2));
      letter = m.group(3).charAt(0);
      password = m.group(3);
    }

    public boolean isValidPart1() {
      int numOccur = 0;
      for (char l : password.toCharArray()) {
        if (l == letter) ++numOccur;
      }
      return numOccur >= num1 && numOccur <= num2;
    }

    @Override public String toString() {
      return "PasswordCheck{" +
          "num1=" + num1 +
          ", num2=" + num2 +
          ", letter=" + letter +
          ", password='" + password + '\'' +
          '}';
    }
  }
  public static void main(String[] args) {
    var checks = getData();
    var count = checks.stream().filter(PasswordCheck::isValidPart1).count();
    System.out.println(count);
  }

  /**
   * Load the lines of text from a file into memory
   * @return a list of the integers in the file
   */
  private static List<PasswordCheck> getData() {
    try {
      String filename = "/Users/daveb/devel/java-lessons/src/main/resources/examples/adventcode/Day2Test.txt";
      Stream<String> linesStream = Files.lines(Paths.get(filename));
      return linesStream.map(PasswordCheck::new).collect(Collectors.toList());
    } catch (IOException e) {
      System.err.println(e.toString());
      return Collections.emptyList();
    }
  }
}
