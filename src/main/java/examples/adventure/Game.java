package examples.adventure;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

public abstract class Game {
  protected int condition = 100;
  protected String conditionType = "Health";
  protected Place location;

  public void play() {

    var scanner = new Scanner(System.in);
    var running = true;
    var stopCommands = List.of("stop", "end", "quit");

    while (running) {
      out.println("You are at " + location);

      processEvents();

      out.printf("Your %s is %d\n", conditionType, condition);
      var places = location.transitions;
      String placesCommaSeparated = places.stream().map(place -> place.name).collect(Collectors.joining(", "));
      out.println("You can go to " + placesCommaSeparated);
      out.println("Where to? ");
      var response = scanner.nextLine();
      if (stopCommands.contains(response.toLowerCase())) {
        running = false;
      } else if (!response.isEmpty()){
        // Get the first place whose name contains the response
        var matches = places.stream().filter(matches(response)).collect(Collectors.toList());
        switch (matches.size()) {
          case 0:
            out.printf("No place matches “%s”\n", response);
            break;
          case 1:
            location = matches.get(0);
            break;
          default:
            out.printf("More than one place matches “%s”\n", response);
        }
      }
    }
  }

  private void processEvents() {
    for (Event event : location.events) {
      condition += event.process();
    }
  }

  private Predicate<Place> matches(String response) {
    String responseLower = response.toLowerCase();
    return place -> place.name.toLowerCase().contains(responseLower);
  }
}
