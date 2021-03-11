package examples.wordladder;

import java.util.ArrayList;
import java.util.List;

public class WordNode {
  public final String word;
  public final List<WordNode> parents = new ArrayList<>();
  public final List<WordNode> children = new ArrayList<>();

  public WordNode(String word) {
    this.word = word;
  }

  @Override public int hashCode() {
    return word.hashCode();
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WordNode wordNode = (WordNode) o;
    return word.equals(wordNode.word);
  }

  @Override public String toString() {
    return word;
  }
}
