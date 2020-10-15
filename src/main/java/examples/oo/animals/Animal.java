package examples.oo.animals;

public class Animal {
  protected final String name;

  public Animal(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println("Yum, yum!");
  }

  @Override public String toString() {
    return "I am an animal";
  }
}
