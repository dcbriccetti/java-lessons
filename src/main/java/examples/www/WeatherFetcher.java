package examples.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/** Fetch weather */
public class WeatherFetcher {
  public static void main(String[] args) throws IOException {
    var url = new URL("https://w1.weather.gov/data/METAR/KCCR.1.txt");
    List<String> lines = new BufferedReader(new InputStreamReader(
        url.openConnection().getInputStream())).lines()
        .collect(Collectors.toList());
    String metar = lines.get(3);
    // Use the regex we made to extract the three elements.
    // Print them.
    // Look at RegExPractice for examples.
    // METAR (K\w{3}).* (\d{3})(\d{2})
    System.out.println(metar);
  }
}

