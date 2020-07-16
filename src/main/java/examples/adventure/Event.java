package examples.adventure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static java.lang.System.out;

class Event {
  final float probability;
  final String description;
  final int conditionImpact;
  final protected Collection<Event> elseEvents = new ArrayList<>();
  private final Random random = new Random();

  public Event(float probability, String description, int conditionImpact) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = conditionImpact;
  }

  public void addElseEvents(Event... events) {
    Collections.addAll(elseEvents, events);
  }

  public int process() {
    int conditionChangeSum = 0;
    if (random.nextFloat() < probability) {
      out.println(description);
      conditionChangeSum += conditionImpact;
    } else {
      for (Event elseEvent : elseEvents) {
        conditionChangeSum += elseEvent.process();
      }
    }
    return conditionChangeSum;
  }

  @Override public String toString() {
    return "Event{" +
        "probability=" + probability +
        ", description='" + description + '\'' +
        '}';
  }
}
