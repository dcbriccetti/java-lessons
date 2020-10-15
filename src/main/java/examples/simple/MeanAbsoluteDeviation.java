package examples.simple;

import java.util.Arrays;

public class MeanAbsoluteDeviation {

  public static float calculate(int[] numbers) {
    // Find the sum of the numbers
    int sum = 0;
    for (int number : numbers)
      sum += number;
    // Compute the mean
    float mean = (float) sum / numbers.length;
    // Compute the sum of deviations
    float sumOfDeviations = 0;
    for (int number : numbers) {
      // for each number, find its deviation from the mean
      float deviationFromMean = Math.abs(mean - number);
      // Add dist to sumOfDistances, changing sumOfDistances
      sumOfDeviations += deviationFromMean;
    }
    // return the average distance
    return sumOfDeviations / numbers.length;
  }

  public static float calculateUsingStreams(int[] numbers) {
    // Find the sum of the numbers
    float sum = Arrays.stream(numbers).sum();
    // Compute the mean
    float mean = sum / numbers.length;
    return (float) Arrays.stream(numbers).mapToDouble(number -> Math.abs(mean - number)).sum() / numbers.length;
  }
}
