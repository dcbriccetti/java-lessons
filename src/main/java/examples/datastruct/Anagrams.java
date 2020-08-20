package examples.datastruct;

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

  public List<String> getRandom() {
    return getRandom(true);
  }

  public List<String> getRandom(boolean remove) {
    int i = rnd.nextInt(anagramGroups.size());
    List<String> group = anagramGroups.get(i);
    if (remove) anagramGroups.remove(i);
    return group;
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
