package examples.adventure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static java.lang.System.out;

/** A game event, including the probability of its happening */
class Event {
  final float probability;
  final String description;
  final int conditionImpact;
  final protected Collection<Event> elseEvents = new ArrayList<>();
  private final Random random = new Random();

  /**
   * Creates an Event.
   * @param probability a number between 0 and 1
   * @param description the description of the event
   * @param conditionImpact the impact, positive or negative, on the player’s condition
   */
  public Event(float probability, String description, int conditionImpact) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = conditionImpact;
  }

  /**
   * Chains one or more events to an event, so that if the event occurs,
   * each of the chained events may also occur.
   * @param events a sequence of Events to chain
   */
  public void addElseEvents(Event... events) {
    Collections.addAll(elseEvents, events);
  }

  /**
   * Process the event.
   * @return the change in the player’s condition
   */
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
