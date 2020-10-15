package examples.oo.animals;

public class Parrot extends Aves {
  public Parrot(String name) {
    super(name);
  }

  @Override public String toString() {
    return "I am a parrot named " + name;
  }

  @Override public void eat() {
    System.out.println("Snicker-snak! I ate a seed.");
  }
}
