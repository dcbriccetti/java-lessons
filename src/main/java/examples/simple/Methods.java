package examples.simple;

import java.time.LocalTime;

/** Illustrates calling a method with no arguments, and calling a method with one argument. */
public class Methods {
  public static void main(String[] args) {
    printTime();

    System.out.println(celsiusToFahrenheit(0));
    System.out.println(celsiusToFahrenheit(100));

    // Can you add a loop to display the temperature in C° for all F temperatures between 0° and 100°?
  }

  static void printTime() {
    System.out.println(LocalTime.now());
  }

  /**
   * Converts a celsius temperature to fahrenheit.
   * @param tempInC a temperature in celsius
   * @return the temperature in fahrenheit
   */
  static float celsiusToFahrenheit(float tempInC) {
    return tempInC * 1.8f + 32;
  }
}
