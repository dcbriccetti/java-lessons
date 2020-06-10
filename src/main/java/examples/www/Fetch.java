package examples.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Fetch {
  public static void main(String[] args) {

    try {
      var conn = (HttpURLConnection) new URL("http://davebsoft.com").openConnection();
      var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      conn.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
