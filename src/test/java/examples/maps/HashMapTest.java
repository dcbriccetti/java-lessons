package examples.maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

  @Test
  void putAndGet() {
    var map = new HashMap<String, Integer>();
    map.put("Dave", 100);
    map.put("Ben", 200);
    map.put("Bne", 300);
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

  @Test
  void remove() {
    var map = new HashMap<String, Integer>();
    var key = "Dave";
    map.put(key, 100);
    map.remove(key);
    assertNull(map.get(key));
  }

  @Test
  void removeFirstMultiple() {
    var map = new HashMap<String, Integer>();
    map.put("abc", 101);
    map.put("bca", 102);
    map.put("cab", 103);
    map.remove("cab");
    assertNull(map.get("cab"));
    assertEquals(101, map.get("abc"));
    assertEquals(102, map.get("bca"));
  }

  @Test
  void removeMiddleMultiple() {
    var map = new HashMap<String, Integer>();
    map.put("abc", 101);
    map.put("bca", 102);
    map.put("cab", 103);
    map.remove("bca");
    assertNull(map.get("bca"));
    assertEquals(101, map.get("abc"));
    assertEquals(103, map.get("cab"));
  }

  @Test
  void removeLastMultiple() {
    var map = new HashMap<String, Integer>();
    map.put("abc", 101);
    map.put("bca", 102);
    map.put("cab", 103);
    map.remove("abc");
    assertNull(map.get("abc"));
    assertEquals(102, map.get("bca"));
    assertEquals(103, map.get("cab"));
  }

  @Test
  void contains() {
    var map = new HashMap<String, Integer>();
    var key = "abc";
    assertFalse(map.contains(key));
    map.put(key, 101);
    assertTrue(map.contains(key));
  }
}
