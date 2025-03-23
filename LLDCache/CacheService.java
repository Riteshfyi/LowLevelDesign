import java.util.HashMap;
import exceptions.*;



public class CacheService {
    private HashMap<Object,Object> cache;
    private int capacity;
    private EvictionStrategy evictionStrategy;
    public CacheService(int capacity, EvictionStrategy evictionStrategy){
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
    }
    public void put(Object Key,Object Value){
        if(Key == null){throw new InvalidKeyException();};
        if(isFull()){evict();};

        cache.put(Key,Value);
        evictionStrategy.updateKey(Key);
    }
    public Object get( Object Key){
        if(!cache.containsKey(Key))return null;
        evictionStrategy.updateKey(Key);
        return cache.get(Key);
    }

    public void evict() {
        Object key = getEvictKey();
        if (key != null) {
            cache.remove(key);
            eraseEvictKey(key);
        }
    }


    public Object getEvictKey(){
        return evictionStrategy.getKey();
    }

    public void eraseEvictKey(Object Key){
        System.out.println(Key + " is Deleted");
        evictionStrategy.removeKey(Key);
    }

    public void setCapacity(int newCapacity) {
        if (newCapacity < 0) {
            throw new InvalidCapacityException();
        }
        this.capacity = newCapacity;
    }

    public boolean isFull(){
        return cache.size() == capacity;
    }
}
