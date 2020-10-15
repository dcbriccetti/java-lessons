package examples.oo.animals;

public class Dog extends Mammal {
  public Dog(String name) {
    super(name);
  }

  @Override public void eat() {
    System.out.println("Woof, woof! Slobber, slobber!");
  }

  @Override public String toString() {
    return "I am a dog named " + name;
  }
}
