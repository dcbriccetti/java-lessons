package examples.maps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

  @Test
  void putAndGet() {
    var map = new HashMap<String, Integer>();
    map.put("Dave", 100);
    map.put("Ben", 200);
    map.put("Bne", 300);
    System.out.println(Arrays.toString(map.buckets));
    assertEquals(100, map.get("Dave"));
    assertEquals(200, map.get("Ben"));
    assertEquals(300, map.get("Bne"));
    assertNull(map.get(""));
  }

  @Test
  void updateValue() {
    var map = new HashMap<String, Integer>();
    var key = "Dave";
    map.put(key, 100);
    assertEquals(100, map.get(key));
    map.put(key, 101);
    assertEquals(101, map.get(key));
  }
}
