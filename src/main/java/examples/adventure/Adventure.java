package examples.adventure;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

/** This very simple text adventure game uses Lists and Maps to store information about the world. */
public class Adventure {

  static class Place {
    private final String name;
    private final String description;

    Place(String name, String description) {
      this.name = name;
      this.description = description;
    }

    @Override public String toString() {
      return name + ": " + description;
    }
  }

  public static void main(String[] args) {
    new Adventure().play();
  }

  public void play() {
    var farm = new Place("Farm", "an old farm with animals");
    var town = new Place("Town", "a small town in the middle of nowhere");
    var airport = new Place("Airport", "a one-runway airport, mostly used by crop dusters");
    var location = farm;
    var transitions = Map.of(
        farm,     List.of(town),
        town,     List.of(farm, airport),
        airport,  List.of(town)
    );
    var scanner = new Scanner(System.in);
    var running = true;

    while (running) {
      out.println("You are at " + location);

      // Some event happens with a given probability
      if (new Random().nextFloat() < 0.5) {
        out.println("You find a pot of gold");
      }

      var places = transitions.get(location);
      out.println("You can go to " + places);
      out.println("Where to? ");
      var response = scanner.nextLine();
      if (response.equals("stop")) {
        running = false;
      } else {
        var maybePlace = places.stream().filter(place -> place.name.equalsIgnoreCase(response)).findFirst();
        if (maybePlace.isPresent()) {
          location = maybePlace.get();
        } else {
          out.println("You can't go there.");
        }
      }
    }
  }
}
