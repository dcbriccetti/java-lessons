package examples.maps;

public class HashMap<K, V> {

  private static class Link<K, V> {
    private final K key;
    private V value;
    private Link<K, V> next;

    public Link(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int NUM_BUCKETS = 16;
  private final Link<K, V>[] buckets = new Link[NUM_BUCKETS];

  public void put(K key, V value) {
    int index = hashIndex(key);
    var existingBucket = buckets[index];

    if (existingBucket == null) {
      buckets[index] = new Link<>(key, value);
      return;
    }

    boolean keyFound = false;

    for (Link<K, V> link = existingBucket; link != null && !keyFound; link = link.next)
      if (link.key.equals(key)) {
        link.value = value;
        keyFound = true;
      }

    if (!keyFound) {
      var newHead = new Link<>(key, value);
      newHead.next = existingBucket;
      buckets[index] = newHead;
    }
  }

  public V get(K key) {
    for (Link<K, V> link = buckets[hashIndex(key)]; link != null; link = link.next)
      if (link.key.equals(key))
        return link.value;
    return null;
  }

  public void remove(K key) {
    var index = hashIndex(key);
    Link<K, V> prev = null;
    for (Link<K, V> link = buckets[index]; link != null; link = link.next) {
      if (link.key.equals(key)) {
        if (prev == null)
          buckets[index] = link.next;
        else
          prev.next = link.next;
      }
      prev = link;
    }

  }

  private int hashIndex(K key) {
    var keyString = key.toString();
    int sum = keyString.codePoints().sum();
    int index = sum % NUM_BUCKETS;
    System.out.printf("%s %d %d\n", key, sum, index);
    return index;
  }
}
