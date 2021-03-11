package examples.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPractice {
  public static void main(String[] args) {
    // Map of food name (String) to the cost (Integer)
    // The food name is the key. That’s what we use to
    // look up the cost. For example, “How much does
    // milk cost?”.
    Map<String, Integer> foodCosts = new HashMap<>();
    foodCosts.put("milk", 3);
    foodCosts.put("butter", 4);
    foodCosts.put("bread", 2);
//    System.out.println(foodCosts);

    Map<String, String> codeNames = new HashMap<>();
    codeNames.put("James Bond", "007");
    codeNames.put("Pete Williams", "News Man");
//    System.out.println(codeNames.get("James Bond"));

    Map<String, String> predecessors = new HashMap<>();
    // Add 5 elements, connecting f to e, e to d, …, b to a
    predecessors.put("f", "e");
    predecessors.put("e", "d");
    predecessors.put("d", "c");
    predecessors.put("c", "b");
    predecessors.put("b", "a");
//    System.out.println(predecessors.keySet());

    // Write code to follow all the way from f back to a
    var word = "f";
    List<String> words = new ArrayList<>(); // When done, will hold a, b, c, d, e, f

    // A loop that continues while we keep finding predecessors
    while (word != null) {
      // Store it at the beginning of the list (otherwise they will be reversed)
      words.add(0, word);
      // How do we look up the predecessor of word?  (I’ll wait.)
      word = predecessors.get(word);
    }
    System.out.println(String.join(" -> ", words));
  }
}
