package examples.spell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
  private Set<String> words = new HashSet<>();

  public Dictionary() {
    words.addAll(List.of("cat", "dog", "monkey"));
  }

  public boolean contains(String word) {
    return words.contains(word);
  }
}
