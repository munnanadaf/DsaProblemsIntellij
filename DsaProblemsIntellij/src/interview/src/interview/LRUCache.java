package interview;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return cacheMap.get(key);
    }

    public synchronized void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public synchronized void displayCache() {
        System.out.println(cacheMap.keySet());
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.displayCache(); // [1, 2, 3]

        cache.get(2); // Accessing 2 to make it the most recently used
        cache.put(4, "Four"); // Adding 4, should evict 1 as it's the least recently used
        cache.displayCache(); // [2, 3, 4]

        cache.put(5, "Five"); // Adding 5, should evict 3
        cache.displayCache(); // [2, 4, 5]
    }
}
