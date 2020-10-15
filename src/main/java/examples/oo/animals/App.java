package examples.oo.animals;

public class App {
  public static void main(String[] args) {
    var dog = new GermanShepard("Cody");
    System.out.println(dog);
    dog.eat();

    var mammal = new Mammal("Jose");
    System.out.println(mammal);
    mammal.eat();

    var parrot = new Parrot("Goose");
    System.out.println(parrot);
    parrot.eat();
  }
}
