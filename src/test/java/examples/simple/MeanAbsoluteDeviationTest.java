package examples.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeanAbsoluteDeviationTest {

  @Test
  void calculate() {
    int[] set1 = {3, 3};
    int[] set2 = {1, 2, 3, 4, 5};

    assertEquals(0.0, MeanAbsoluteDeviation.calculate(set1));
    assertEquals(0.0, MeanAbsoluteDeviation.calculateUsingStreams(set1));

    assertEquals(1.2, MeanAbsoluteDeviation.calculate(set2), 1e-5);
    assertEquals(1.2, MeanAbsoluteDeviation.calculateUsingStreams(set2), 1e-5);
  }
}
