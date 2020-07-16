package examples.adventure;

import java.util.List;

/** This very simple text adventure game uses Lists and Maps to store information about the world. */
public class RuralTravels extends Game {

  public static void main(String[] args) {
    new RuralTravels().play();
  }

  public RuralTravels() {
    Event pigKnockOverEvent = new Event(0.4f, "A friendly pig knocks you over", -10);
    pigKnockOverEvent.addElseEvents(List.of(new Event(1, "Your lovely pig oinks and greets you.", 10)));
    var farmEvents = List.of(pigKnockOverEvent);
    var farm = new Place("Farm", "an old farm with animals", farmEvents);

    var town = new Place("Town", "a small town in the middle of nowhere");

    var airport = new Place("Airport", "a one-runway airport, mostly used by crop dusters");

    location = farm;

    farm.addTransitions(town);
    town.addTransitions(farm, airport);
    airport.addTransitions(town);
  }

}
