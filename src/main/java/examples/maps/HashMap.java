package examples.maps;

import java.util.LinkedList;

public class HashMap<K, V> {
  public static class Bucket<K, V> {
    @Override public String toString() {
      return entries.toString();
    }

    public static class Entry<K, V> {
      public K key;
      public V value;

      public Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }

      @Override public String toString() {
        return key + ": " + value;
      }
    }

    public final LinkedList<Entry<K, V>> entries = new LinkedList<>();

    public Bucket(K key, V value) {
      entries.add(new Entry<>(key, value));
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

    for (Bucket.Entry<K, V> entry : existingBucket.entries) {
      if (entry.key.equals(key)) {
        entry.value = value;
        keyFound = true;
      }
    }

    if (! keyFound) {
      existingBucket.entries.add(new Bucket.Entry<>(key, value));
    }
  }

  public V get(K key) {
    for (Bucket.Entry<K, V> entry : buckets[hashIndex(key)].entries) {
      if (entry.key.equals(key)) return entry.value;
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
