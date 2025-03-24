import java.util.HashMap;
import exceptions.*;



public class CacheService <Key,Value>{
    private Storage<Key,Value> storage;
    private int capacity;
    private EvictionStrategy<Key> evictionStrategy;
    public CacheService(int capacity, EvictionStrategy evictionStrategy,Storage storage){
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
        this.storage = storage;
    }
    public void put(Key key,Value value){
        if(key == null){throw new InvalidKeyException();};
        if(isFull()){evict();};

        storage.put(key,value);
        evictionStrategy.updateKey(key);
    }
    public Value get( Key key){
        if(!storage.containsKey(key))return null;
        evictionStrategy.updateKey(key);
        return storage.get(key);
    }

    public void evict() {
        Key key = getEvictKey();
        if (key != null) {
            storage.remove(key);
            eraseEvictKey(key);
        }
    }


    public Key getEvictKey(){
        return evictionStrategy.getKey();
    }

    public void eraseEvictKey(Key Key){
        System.out.println(Key + " is Deleted");
        evictionStrategy.removeKey(Key);
    }



    public boolean isFull(){
        return storage.isFull();
    }
}
