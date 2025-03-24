public class CacheFactory {
    private static CacheService<String,Integer> cache;
    public CacheFactory(){};
    public static CacheService getInstance(){
        if(cache == null){
            synchronized (CacheFactory.class){
                if(cache == null){
                    EvictionStrategy<String> evictionStrategy = new LRUStrategy<>();
                    Storage<String , Integer> storage = new HashMapStorage<>(4);
                    cache = new CacheService<>(4,evictionStrategy,storage);
                }
            }
        }
        return cache;
    }
}
