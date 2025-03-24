import java.util.HashMap;
import exceptions.*;



public class CacheService <Key,Value>{
    private Storage<Key,Value> storage;
    private int capacity;
    private EvictionStrategy<Key> evictionStrategy;
    private final Object lock1;
    private final Object lock2;
    public CacheService(int capacity, EvictionStrategy evictionStrategy, Storage storage){
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
        this.storage = storage;
        this.lock1 = new Object();
        this.lock2 = new Object();
    }
    public void put(Key key,Value value){
        if(key == null){throw new InvalidKeyException();};
        synchronized (lock1){
            if(storage.isFull()){evict();};
            storage.put(key,value);
            evictionStrategy.updateKey(key);
        }
    }
    public Value get( Key key){
      synchronized (lock2){
        if(!storage.containsKey(key))return null;
          evictionStrategy.updateKey(key);
      }
        return storage.get(key);
    }

    private void evict() {
        synchronized (lock1){
        Key key = getEvictKey();
        if (key != null) {
            storage.remove(key);
            eraseEvictKey(key);
        }}
    }


    private Key getEvictKey(){
        return evictionStrategy.getKey();
    }

    private void eraseEvictKey(Key Key){
        System.out.println(Key + " is Deleted");
        evictionStrategy.removeKey(Key);
    }

}
