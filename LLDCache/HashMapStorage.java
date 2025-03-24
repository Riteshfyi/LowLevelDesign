import java.util.concurrent.ConcurrentHashMap;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
    private ConcurrentHashMap<Key, Value> map;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.map = new ConcurrentHashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) {
        map.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public boolean containsKey(Key key) {
        return map.containsKey(key);
    }
    @Override
    public boolean isFull(){
        return map.size() == capacity;
    }
}
