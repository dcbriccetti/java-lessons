package examples.oo.plants;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    // Create an empty list of plants
    var plants = new ArrayList<Plant>();

    // Create a bean and a tree
    var bean = new Bean();
    var tree = new Tree();

    // Add the bean and tree instances to the plants list
    plants.add(bean);
    plants.add(tree);

    // Print the entire plants list
    System.out.println(plants);

    // Have all the plants grow
    for (Plant plant : plants) {
      plant.grow();
    }

    // Print the entire plants list
    System.out.println(plants);
  }
}
