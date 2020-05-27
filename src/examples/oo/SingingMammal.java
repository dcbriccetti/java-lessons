package examples.oo;

public class SingingMammal extends TalkingMammal {
  public SingingMammal(String name) {
    super(name);
  }

  public void sing() {
    System.out.println("La, la lah! My name is " + name + ".");
  }

  public static void main(String[] args) {
    var betsy = new SingingMammal("Betsy");
    betsy.sing();
  }
}
