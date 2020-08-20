package examples.words;

import examples.io.WordReader;

import java.text.NumberFormat;
import java.util.Scanner;

import static java.lang.System.out;

public class AnagramsGame {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var anagrams = new Anagrams(WordReader.commonWords());
    var fmt = NumberFormat.getInstance();
    out.printf("Hello! I will give you words, and you will give me an anagram for each word.\n" +
        "We have %s anagram groups found from %s words. Respond with nothing to end.\n\n",
        fmt.format(anagrams.size()), fmt.format(anagrams.numWords()));
    boolean run = true;
    int right = 0;
    int wrong = 0;
    while (run) {
      var group = anagrams.randomlySelectGroup();
      String word = group.get(0);
      var others = group.subList(1, group.size());
      out.printf("%s? ", word);
      String response = scanner.nextLine();
      if (response.isEmpty())
        run = false;
      else {
        if (others.contains(response)) {
          out.println("Right");
          ++right;
        } else {
          out.println(String.join(", ", others));
          ++wrong;
        }
      }
    }
    out.printf("Right: %d, wrong: %d", right, wrong);
  }
}
