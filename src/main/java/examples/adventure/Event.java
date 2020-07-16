package examples.adventure;

import java.util.ArrayList;
import java.util.Collection;

class Event {
  final float probability;
  final String description;
  final int conditionImpact;
  protected Collection<Event> elseEvents = new ArrayList<>();

  public Event(float probability, String description, int conditionImpact) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = conditionImpact;
  }

  public Event(float probability, String description) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = 0;
  }

  public void addElseEvents(Collection<Event> events) {
    this.elseEvents = events;
  }

  @Override public String toString() {
    return "Event{" +
        "probability=" + probability +
        ", description='" + description + '\'' +
        '}';
  }
}
