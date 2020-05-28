package examples.simple;

public class Functions {
  public static void main(String[] args) {
    System.out.println(celsiusToFahrenheit(0));
    System.out.println(celsiusToFahrenheit(100));

    // Can you add a loop to display the temperature in C° for all F temperatures between 0° and 100°?
  }

  static float celsiusToFahrenheit(float tempInC) {
    return tempInC * 1.8f + 32;
  }
}
