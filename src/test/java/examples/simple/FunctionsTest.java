package examples.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

  @Test
  void celsiusToFahrenheit() {
    assertEquals(212, Functions.celsiusToFahrenheit(100));
    assertEquals( 32, Functions.celsiusToFahrenheit(0));
  }
}
