package examples.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

  @Test
  void celsiusToFahrenheit() {
    assertEquals(212, Methods.celsiusToFahrenheit(100));
    assertEquals( 32, Methods.celsiusToFahrenheit(0));
  }
}
