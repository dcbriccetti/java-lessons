package examples.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class Fetch {
  public static void main(String[] args) {

    try {
      var conn = (HttpURLConnection) new URL("http://davebsoft.com").openConnection();
      var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line = reader.lines().collect(Collectors.joining("\n"));
      conn.disconnect();
      System.out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
