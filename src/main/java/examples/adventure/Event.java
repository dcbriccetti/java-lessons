package examples.adventure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Event {
  final float probability;
  final String description;
  final int conditionImpact;
  final protected Collection<Event> elseEvents = new ArrayList<>();

  public Event(float probability, String description, int conditionImpact) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = conditionImpact;
  }

  public void addElseEvents(Event... events) {
    Collections.addAll(elseEvents, events);
  }

  @Override public String toString() {
    return "Event{" +
        "probability=" + probability +
        ", description='" + description + '\'' +
        '}';
  }
}
