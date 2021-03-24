package examples.maps;

public class HashMap<K, V> {

  public static class Bucket<K, V> {
    private Entry<K, V> entry;

    @Override public String toString() {
      return entry.toString();
    }

    public static class Entry<K, V> {
      public K key;
      public V value;
      public Entry<K, V> next;

      public Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }

      @Override public String toString() {
        return key + ": " + value;
      }
    }

    public Bucket(K key, V value) {
      entry = new Entry<>(key, value);
    }
  }

  private final int NUM_BUCKETS = 16;
  public Bucket<K, V>[] buckets = new Bucket[NUM_BUCKETS];

  public void put(K key, V value) {
    int index = hashIndex(key);
    var existingBucket = buckets[index];

    if (existingBucket == null) {
      buckets[index] = new Bucket<>(key, value);
      return;
    }

    boolean keyFound = false;

    Bucket.Entry<K, V> entry = existingBucket.entry;
    while (entry != null) {
      if (entry.key.equals(key)) {
        entry.value = value;
        keyFound = true;
      }
      entry = entry.next;
    }

    if (! keyFound) {
      var formerHead = existingBucket.entry;
      var newHead = new Bucket.Entry<>(key, value);
      newHead.next = formerHead;
      existingBucket.entry = newHead;
    }
  }

  public V get(K key) {
    var entry = buckets[hashIndex(key)].entry;
    while (entry != null) {
      if (entry.key.equals(key)) return entry.value;
      entry = entry.next;
    }
    return null;
  }

  private int hashIndex(K key) {
    var keyString = key.toString();
    int sum = keyString.codePoints().sum();
    int index = sum % NUM_BUCKETS;
    System.out.printf("%s %d %d\n", key, sum, index);
    return index;
  }
}
