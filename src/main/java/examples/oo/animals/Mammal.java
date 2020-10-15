package examples.oo.animals;

public class Mammal extends Animal {
  public Mammal(String name) {
    super(name);
  }

  @Override public String toString() {
    return "I am a mammal";
  }
}

