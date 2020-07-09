package examples.adventure;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

/** This very simple text adventure game uses Lists and Maps to store information about the world. */
public class Adventure {

  private final Random random = new Random();

  public static void main(String[] args) {
    new Adventure().play();
  }

  public void play() {
    var condition = 100;
    var conditionType = "Health";

    var farmEvents = List.of(
        new Event(0.4f, "A friendly pig knocks you over", -10)
    );
    var farm = new Place("Farm", "an old farm with animals", farmEvents);

    var town = new Place("Town", "a small town in the middle of nowhere");

    var airport = new Place("Airport", "a one-runway airport, mostly used by crop dusters");

    var location = farm;

    farm.addTransitions(town);
    town.addTransitions(farm, airport);
    airport.addTransitions(town);

    var scanner = new Scanner(System.in);
    var running = true;

    while (running) {
      out.println("You are at " + location);

      for (Event event : location.events) {
        if (random.nextFloat() < event.probability) {
          out.println(event.description);
          condition += event.conditionImpact;
        }
      }

      out.printf("Your %s is %d\n", conditionType, condition);
      var places = location.transitions;
      out.println("You can go to " + places.stream().map(Place::toString).collect(Collectors.joining(", ")));
      out.println("Where to? ");
      var response = scanner.nextLine();
      if (response.equalsIgnoreCase("stop")) {
        running = false;
      } else {
        var maybePlace = places.stream().filter(place -> place.name.toLowerCase().contains(response.toLowerCase())).findFirst();
        if (maybePlace.isPresent()) {
          location = maybePlace.get();
        } else {
          out.println("You can't go there.");
        }
      }
    }
  }
}
