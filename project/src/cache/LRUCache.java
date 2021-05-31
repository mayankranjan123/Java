package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    Deque<CacheEntry> deque = new LinkedList<>();
    Map<Integer, CacheEntry> map = new HashMap<>();
    int CACHE_SIZE = 3;

    class CacheEntry {
        int key;
        String value;

        public CacheEntry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.putEntryIntoCache(1, "Product-1-Info");
        cache.putEntryIntoCache(2, "Product-2-Info");
        cache.putEntryIntoCache(3, "Product-3-Info");
        cache.putEntryIntoCache(4, "Product-4-Info");

        System.out.println(cache.getFromCache(2));
        System.out.println(cache.getFromCache(6));
    }

    private String getFromCache(int key) {
        if (map.containsKey(key)) {
            CacheEntry cacheEntry = map.get(key);
            deque.remove(cacheEntry);
            deque.addFirst(cacheEntry);
            return cacheEntry.value;
        }
        return null;
    }

    private void putEntryIntoCache(int key, String value) {
        if (map.containsKey(key)) {
            deque.remove(map.get(key));
        } else {
            if (deque.size() == CACHE_SIZE) {
                CacheEntry entry = deque.getLast();
                deque.removeLast();
                map.remove(entry);
            }
        }
        CacheEntry cacheEntry = new CacheEntry(key, value);
        deque.addFirst(cacheEntry);
        map.put(key, cacheEntry);
    }
}
