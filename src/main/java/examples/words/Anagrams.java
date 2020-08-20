package examples.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {

  private final List<List<String>> anagramGroups;
  private final Random rnd = new Random();
  private final int numWords;

  public List<String> randomlySelectGroup() {
    return randomlySelectGroup(true);
  }

  /**
   * Randomly selects an anagram group and optionally removes it.
   * @param remove whether we want to remove the group
   * @return an anagram group
   */
  public List<String> randomlySelectGroup(boolean remove) {
    if (anagramGroups.size() == 0)
      throw new IllegalStateException("There are no anagram groups");
    int i = rnd.nextInt(anagramGroups.size());
    List<String> group = anagramGroups.get(i);
    if (remove) anagramGroups.remove(i);
    return group;
  }

  public int size() {
    return anagramGroups.size();
  }

  public int numWords() {
    return numWords;
  }

  class SortedWord {
    String sortedWord;
    String word;

    public SortedWord(String word) {
      this.sortedWord = sorted(word);
      this.word = word;
    }
  }

  private String sorted(String word) {
    var chars = word.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }

  public Anagrams(List<String> words) {
    numWords = words.size();
    Map<String, List<SortedWord>> grouped = words.stream().
        filter(word -> word.length() > 2).
        map(SortedWord::new).
        collect(Collectors.groupingBy(sw -> sw.sortedWord));
    anagramGroups = new ArrayList<>(grouped.entrySet().stream().
        filter(entry -> entry.getValue().size() > 1).
        collect(Collectors.toMap(Map.Entry::getKey, getWordList())).values());
  }

  public Function<Map.Entry<String, List<SortedWord>>, List<String>> getWordList() {
    return e -> {
      var wordList = e.getValue().stream().map(a -> a.word).collect(Collectors.toList());
      Collections.shuffle(wordList);
      return wordList;
    };
  }
}
