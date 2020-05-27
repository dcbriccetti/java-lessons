package examples.simple.oo;

public class TalkingMammal {
  protected final String name;

  public TalkingMammal(String name) {
    this.name = name;
  }

  public void talk() {
    System.out.println("Hi. My name is " + name + " and I can talk.");
  }

  public static void main(String[] args) {
    var ida = new TalkingMammal("Ida");
    ida.talk();
  }
}
