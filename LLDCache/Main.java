public class Main {
    public static void main(String[] args) {
        EvictionStrategy lruStrategy = new LRUStrategy();
        Storage storage = new HashMapStorage(3);
        CacheService<String,Integer> cache = new CacheService(3, lruStrategy,storage);

        cache.put("A", 1);
        cache.put("B", 2);
       System.out.println(cache.get("A")); // Output: 1
        cache.put("C",3);
//        System.out.println(cache.get("A"));
        cache.put("D",2);
        cache.put("X",2);
        System.out.println(cache.get("A"));
        System.out.println(cache.get("D"));
    }

}
